package jaxrs.ihm;

import jaxrs.ihm.util.ScannerUtil;

public class ArreterProgrammeAction implements Action {

	public Integer getId() { return 0; }

	public String getMenu() { return "Arrêter l'application"; }

	public void execute() {
		System.out.println("Aurevoir !");
		ScannerUtil.getInstance().close();
		System.exit(0);
	}
	
}
