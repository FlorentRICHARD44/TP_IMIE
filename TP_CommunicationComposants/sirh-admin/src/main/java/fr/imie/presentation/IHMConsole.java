package fr.imie.presentation;

import java.util.List;
import java.util.Scanner;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.imie.bankocash.soap.BankocashSoapService;
import fr.imie.bankocash.soap.BankocashSoapServiceService;
import fr.imie.bankocash.soap.CompteEntity;
import fr.imie.data.Employee;



public class IHMConsole implements AutoCloseable {
    private final static String API_ADDRESS = "http://localhost:8080/sirh-rest/api";
    /** Scanner used to get informations.
     */
    private Scanner scan;
    /** Constructor.
     */
    public IHMConsole() {
        scan = new Scanner(System.in);
    }

    @Override
    public void close() throws Exception {
        scan.close();
    }

    /** Display a choice of next menu to apply.
     * Gets the selection of user.
     * @return Menu to apply.
     */
    private AppliMenu getMenu() {
        AppliMenu retour = null;
        do {
            System.out.println("Choissir une option:");
            for (AppliMenu opt: AppliMenu.values()) {
                System.out.format(" - %2s -> %s\n", opt.getCode(), opt.getName());
            }
            Integer code = Integer.valueOf(scan.nextLine());
            retour = AppliMenu.getMenu(code);
        } while (retour == null);
        return retour;
    }

    public void run() {
        AppliMenu menuOption;
        do {
            menuOption = getMenu();
            switch (menuOption) {
                case QUIT: System.out.println("Sortie");
                break;
                case EMPLOYEE_DISPLAY: displayEmployeeList();
                break;
                case EMPLOYEE_DELETE: deleteEmployee();
                break;
                case EMPLOYEE_ADD: addEmployee();
                break;
                case EMPLOYEE_MODIFY: modifyEmployee();
                break;
                case COMPTE_ADD: addCompte();
                break;
                case COMPTE_CREDITE: crediteCompte();
                break;
                case COMPTE_DEBITE: debiteCompte();
                break;
                default:System.out.println("Ce menu n'est pas implemente");
                break;
            }
        } while (menuOption != AppliMenu.QUIT);
    }
    
    public List<Employee> getEmployeeList() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_ADDRESS + "/employee");
        Invocation.Builder builder = target.request();
        List<Employee> employeList = builder.get(new GenericType<List<Employee>>(){});
        return employeList;
    }
    
    public Employee getEmployee(Integer id) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_ADDRESS + "/employee");
        Invocation.Builder builder = target.path(String.valueOf(id)).request();
        Employee employee = builder.get(Employee.class);
        return employee;
        
    }
    
    public void displayEmployeeList() {
        for (Employee e : getEmployeeList()) {
            System.out.println(" - " + e.getId() + " " + e.getPrenom() + " " + e.getNom() + " " + e.getMatricule());
        }
    }
    
    public void addEmployee() {
        Employee employee = new Employee();
        employee.setNom(getString("Entrer le nom", "", false));
        employee.setPrenom(getString("Entrer le prénom", "", false));
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_ADDRESS + "/employee");
        Invocation.Builder builder = target.request();
        try {
            employee = builder.post(Entity.entity(employee, MediaType.APPLICATION_JSON),
                                        Employee.class);
            System.out.println("Nouvel employé créé : " + employee.getId() + " " + employee.getPrenom() + " " + employee.getNom() + " " + employee.getMatricule());
        } catch(BadRequestException e) {
            System.out.println("Impossible de créer cet usager");
        }
    }
    
    public void modifyEmployee() {
        displayEmployeeList();
        Employee employee = null;
        do {
            Integer id = getInteger("Selectionner un employé par son ID", null, false);
            employee = getEmployee(id);
        } while(employee == null);
        employee.setNom(getString("Entrer le nom (" + employee.getNom() + ")", "", false));
        employee.setPrenom(getString("Entrer le prénom(" + employee.getPrenom() + ")", "", false));
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_ADDRESS + "/employee");
        Invocation.Builder builder = target.request();
        try {
            employee = builder.put(Entity.entity(employee, MediaType.APPLICATION_JSON),
                                        Employee.class);
            System.out.println("Employé modifié : " + employee.getId() + " " + employee.getPrenom() + " " + employee.getNom() + " " + employee.getMatricule());
        } catch(BadRequestException e) {
            System.out.println("Impossible de modifier cet usager");
        }
        
    }
    
    public void deleteEmployee() {
        displayEmployeeList();
        Integer id = getInteger("Selectionner un employé par son ID", null, false);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_ADDRESS + "/employee");
        Invocation.Builder builder = target.path(String.valueOf(id)).request();
        Response resp = builder.delete();
        System.out.println("Résultat de la requête: " + Status.fromStatusCode(resp.getStatus()));
    }
    
    public void addCompte() {
        displayEmployeeList();
        Integer id = getInteger("Selectionner un employé par son ID", null, false);
        Employee employee = getEmployee(id);
        CompteEntity compte = new CompteEntity();
        compte.setIdTitulaire(employee.getId());
        compte.setNomTitulaire(employee.getNom());
        compte.setPrenomTitulaire(employee.getPrenom());
        BankocashSoapServiceService serviceBanko = new BankocashSoapServiceService();
        BankocashSoapService bankoService = serviceBanko.getBankocashSoapServicePort();
        compte = bankoService.createCompte(compte);
        System.out.println(String.format("Compte créé avec le nom \"%s\". Solde actuel: %.02f €",compte.getNom(), compte.getSolde()));
    }
    
    public void crediteCompte() {
        displayEmployeeList();
        Integer id = getInteger("Selectionner un employé par son ID", null, false);
        Employee employee = getEmployee(id);
        BankocashSoapServiceService serviceBanko = new BankocashSoapServiceService();
        BankocashSoapService bankoService = serviceBanko.getBankocashSoapServicePort();
        List<CompteEntity> compteList = bankoService.findCompteByEmployee(employee.getId());
        if (compteList.size() == 0) {
            System.out.println("Aucun compte n'existe pour l'employé sélectionné");
        } else {
            compteList.stream().forEach(compte -> System.out.println(String.format(" - %d Compte \"%s\". Solde actuel: %.02f €",compte.getId(), compte.getNom(), compte.getSolde())));
            Integer idCompte = getInteger("Choisir l'Id du compte à modifier", null, false);
            CompteEntity compteToModify = null;
            for (CompteEntity compte: compteList) {
                if (compte.getId() == idCompte) {
                    compteToModify = compte;
                    break;
                }
            }
            if (compteToModify == null) {
                System.out.println("L'id renseigné n'existe pas");
            } else {
                Float value = getFloat("Indiquer la somme à créditer: ", null, false);
                if (value > 0) {
                    compteToModify = bankoService.crediteCompte(compteToModify, value);
                    System.out.println(String.format("Compte crédité de %.02f €. Solde actuel: %.02f €.", value, compteToModify.getSolde()));
                } else {
                    System.out.println("La somme créditée doit est positive!");
                }
            }
        }
    }
    
    public void debiteCompte() {
        displayEmployeeList();
        Integer id = getInteger("Selectionner un employé par son ID", null, false);
        Employee employee = getEmployee(id);
        BankocashSoapServiceService serviceBanko = new BankocashSoapServiceService();
        BankocashSoapService bankoService = serviceBanko.getBankocashSoapServicePort();
        List<CompteEntity> compteList = bankoService.findCompteByEmployee(employee.getId());
        if (compteList.size() == 0) {
            System.out.println("Aucun compte n'existe pour l'employé sélectionné");
        } else {
            compteList.stream().forEach(compte -> System.out.println(String.format(" - %d Compte \"%s\". Solde actuel: %.02f €",compte.getId(), compte.getNom(), compte.getSolde())));
            Integer idCompte = getInteger("Choisir l'Id du compte à modifier", null, false);
            CompteEntity compteToModify = null;
            for (CompteEntity compte: compteList) {
                if (compte.getId() == idCompte) {
                    compteToModify = compte;
                    break;
                }
            }
            if (compteToModify == null) {
                System.out.println("L'id renseigné n'existe pas");
            } else {
                Float value = getFloat("Indiquer la somme à débiter: ", null, false);
                if (value > 0) {
                    compteToModify = bankoService.debiteCompte(compteToModify, value);
                    System.out.println(String.format("Compte débité de %.02f €. Solde actuel: %.02f €.", value, compteToModify.getSolde()));
                } else {
                    System.out.println("La somme débitée doit être positive!");
                }
            }
        }
    }

    /** Prints a message in the console and return the value set by the user.
     * If the line returned is empty, a default value is returned
     * If the line is "**", null is returned.
     * @param message Message to print
     * @param defaultValue Default value of the Integer
     * @param nullAccepted If set to true, the value null can be returned.
     * @return Value returned.
     */
    private Integer getInteger(final String message,
                             final Integer defaultValue,
                             final boolean nullAccepted) {
        Integer retVal = null;
        do {
            System.out.format("%s", message);
            String str = scan.nextLine();
            if (!str.equals("**")) {
                if (str.length() > 0) {
                    retVal = Integer.valueOf(str);
                } else {
                    retVal = defaultValue;
                }
            }
        } while (!(nullAccepted || (retVal != null)));
        return retVal;
    }
    
    /** Prints a message in the console and return the value set by the user.
     * If the line returned is empty, a default value is returned
     * If the line is "**", null is returned.
     * @param message Message to print
     * @param defaultValue Default value of the Float
     * @param nullAccepted If set to true, the value null can be returned.
     * @return Value returned.
     */
    private Float getFloat(final String message,
                             final Float defaultValue,
                             final boolean nullAccepted) {
        Float retVal = null;
        do {
            System.out.format("%s", message);
            String str = scan.nextLine();
            if (!str.equals("**")) {
                if (str.length() > 0) {
                    retVal = Float.valueOf(str);
                } else {
                    retVal = defaultValue;
                }
            }
        } while (!(nullAccepted || (retVal != null)));
        return retVal;
    }

    /** Prints a message in the console and return the value set by the user.
     * If the line returned is empty, a default value is returned
     * If the line is "**", null is returned.
     * @param message Message to print
     * @param defaultValue Default value of the String
     * @param nullAccepted If set to true, the value null can be returned.
     * @return Value returned.
     */
    private String getString(final String message,
                             final String defaultValue,
                             final boolean nullAccepted) {
        String retVal = null;
        do {
            System.out.format("%s", message);
            String str = scan.nextLine();
            if (!str.equals("**")) {
                if (str.length() > 0) {
                    retVal = str;
                } else {
                    retVal = defaultValue;
                }
            }
        } while (!(nullAccepted || (retVal != null)));
        return retVal;
    }
}
