package jaxrs.ihm;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import jaxrs.ihm.domain.Employe;
import jaxrs.service.EmployeClientService;

public class ListerEmployesAction implements Action {
	

	public Integer getId() { return 1; }

	public String getMenu() { return "Lister les employés"; }

	public void execute() {
		System.out.println("Afficher la liste des employés");
		
		try {
			
			List<Employe> employes = new EmployeClientService().findAllEmployes();
			
			employes.stream().forEach(employe -> {
				System.out.println(employe);
			});
		} catch (WebApplicationException e) {
			System.out.println("Impossible de récupérer les employes");
		}
		
		

	}
	
}
