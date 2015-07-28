package jaxrs;

import java.util.Set;
import java.util.stream.Collectors;

import jaxrs.ihm.Action;
import jaxrs.ihm.util.ScannerUtil;

import org.reflections.Reflections;

public class SirhAdminApp {

	public static void main(String[] args) {
		Reflections reflections = new Reflections("jaxrs.ihm");
		Set<Class<? extends Action>> actionClasses = reflections.getSubTypesOf(Action.class);
	
		Set<Action> actions = actionClasses.stream()
				.map(actionClass -> {
					Action action = null;
					try {
						action = actionClass.getConstructor().newInstance();
					} catch (Exception e) {
						e.printStackTrace();
					}
				return action;
		}).collect(Collectors.toSet());
		
		
		while(true) {
			System.out.println("***** SIRH CLIENT *****");
			actions.stream().sorted((a1,a2) -> a1.getId().compareTo(a2.getId())).forEach(action -> {
				System.out.println(action.getId() + ". " + action.getMenu());
			});
			
			Integer choix = ScannerUtil.getInstance().askUserInt("\nVeuillez faire un choix");
			
			actions.stream().filter(action -> action.getId().equals(choix)).forEach(action -> {
				action.execute();
			});
			System.out.println("");
		}
	}

}
