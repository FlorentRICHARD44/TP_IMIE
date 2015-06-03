package fr.imie.formation.poo.tp1;

/** Class representing a Professor/
 * @author Florent RICHARD
 *
 */
public class Professor extends Person {
	/** Salary annual for the professor.
	 */
	private Integer salary;
	
	/** Constructor.
	 * @param name Name of the professor.
	 */
	public Professor(String name) {
		super(name);
		this.salary = 0;
	}

	/** Accessor to the salary.
	 * @return the salary
	 */
	public Integer getSalary() {
		return salary;
	}

	/** Mutator for the salary.
	 * @param salary the salary to set
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}
