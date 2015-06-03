package fr.imie.formation.poo.tp1;

/** Class representing a person.
 * @author Florent RICHARD
 *
 */
public class Person {
	/** Name of the person.
	 */
	private String name;
	
	/** Constructor.
	 * @param name Name of the person.
	 */
	public Person(final String name) {
		this.name = name;
	}
	
	/** Write a hello sentence in the console.
	 */
	public void sayHello() {
		System.out.format("Hello, my name is %s.\n", this.name);
	}

	/** Accessor to the name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** Mutator for the name.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
