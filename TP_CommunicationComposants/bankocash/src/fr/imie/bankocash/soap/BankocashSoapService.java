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
    
     public CompteEntity createCompte(CompteEntity newCompte) {
        return serv.save(newCompte);
    }
    
     public CompteEntity findCompteByEmployee(Integer employee_id) {
         return serv.find
     }

}
