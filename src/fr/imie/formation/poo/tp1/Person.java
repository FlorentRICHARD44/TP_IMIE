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
     * @param pName Name of the person.
     */
    public Person(final String pName) {
        setName(pName);
    }

    /** Write a hello sentence in the console.
     */
    public void sayHello() {
        System.out.format("Hello, my name is %s.\n", this.name);
    }

    /** Accessor to the name.
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /** Mutator for the name.
     * @param pName the name to set
     */
    public final void setName(final String pName) {
        this.name = pName;
    }
}
