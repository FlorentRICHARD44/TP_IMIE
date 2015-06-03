package fr.imie.formation.poo.tp1;

/** Class for testing the TP1.
 * @author imie
 */
public class TestMain {

    /** Main function.
     * @param args Application arguments.
     */
    public static void main(final String[] args) {
        Person alice = new Student("Alice");
        alice.sayHello();
        Person simon = new Professor("Simon", 35000);
        simon.sayHello();
    }
}
