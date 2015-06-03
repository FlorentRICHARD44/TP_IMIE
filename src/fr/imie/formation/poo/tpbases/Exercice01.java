/**
 * 
 */
package fr.imie.formation.poo.tpbases;

import fr.imie.formation.poo.tpbases.CategoryAge;

/**
 * @author Florent RICHARD
 *
 */
public class Exercice01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer age = 3;
		for(CategoryAge cat: CategoryAge.values()) {
			if (age <= cat.getMax() & age >= cat.getMin()) {
				System.out.format("Vous êtes de la catégorie %s", cat.getName());
				break;
			}
		}

	}

}
