package fr.imie.formation.poo.tp1;

/** Class representing a Professor.
 * @author Florent RICHARD
 *
 */
public class Professor extends Person {
    /** Salary annual for the professor.
     */
    private Integer salary;

    /** Constructor.
     * @param name Name of the professor.
     * @param sal Year salary earned by the professor.
     */
    public Professor(final String name, final Integer sal) {
        super(name);
        setSalary(sal);
    }

    /**
     * @see fr.imie.formation.poo.tp1.Person#sayHello()
     */
    @Override
    public final void sayHello() {
        System.out.format(
                "Hello, my name is %s and I earn %d euros by year.\n",
                getName(), this.salary);
    }

    /** Accessor to the salary.
     * @return the salary
     */
    public final Integer getSalary() {
        return salary;
    }

    /** Mutator for the salary.
     * @param sal the salary to set
     */
    public final void setSalary(final Integer sal) {
        this.salary = sal;
    }
}
