package fr.imie.presentation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.imie.data.Employee;



public class IHMConsole implements AutoCloseable {
    /** Scanner used to get informations.
     */
    private Scanner scan;
    /** Formatter for date.
     */
    private SimpleDateFormat dateformat;
    /** Constructor.
     */
    public IHMConsole() {
        scan = new Scanner(System.in);
        dateformat = new SimpleDateFormat("dd/MM/yyyy");
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
                default:System.out.println("Ce menu n'est pas implemente");
                break;
            }
        } while (menuOption != AppliMenu.QUIT);
    }
    
    public List<Employee> getEmployeeList() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/sirh-rest/api/employee");
        Invocation.Builder builder = target.request();
        List<Employee> employeList = builder.get(new GenericType<List<Employee>>(){});
        return employeList;
    }
    
    public Employee getEmployee(Integer id) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/sirh-rest/api/employee");
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
        WebTarget target = client.target("http://localhost:8080/sirh-rest/api/employee");
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
        WebTarget target = client.target("http://localhost:8080/sirh-rest/api/employee");
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
        WebTarget target = client.target("http://localhost:8080/sirh-rest/api/employee");
        Invocation.Builder builder = target.path(String.valueOf(id)).request();
        Response resp = builder.delete();
        System.out.println("Résultat de la requête: " + Status.fromStatusCode(resp.getStatus()));
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
