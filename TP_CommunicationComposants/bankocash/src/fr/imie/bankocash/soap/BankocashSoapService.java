package fr.imie.bankocash.soap;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.imie.bankocash.entities.CompteEntity;
import fr.imie.bankocash.services.BankService;

@WebService
public class BankocashSoapService {
    @EJB
    private BankService serv;

    public BankocashSoapService() {
        super();
    }
    
     public void createCompte(CompteEntity newCompte) {
        serv.save(newCompte);
        System.out.println("compte créé");
    }

}
