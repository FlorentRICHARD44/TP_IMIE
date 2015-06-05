package fr.imie.formation.poo.tpthread;

/** class used to launch the application for tests.
 * @author Florent RICHARD
 */
public final class Launcher {

    /** Constructor, not used.
     */
    private Launcher() {
    }

    /** Main function.
     * @param args Arguments of the application.
     */
    public static void main(final String[] args) {
        IAffichage aff = new AffichageConsole();
        Calcul c1 = new Calcul(12, aff);
        Calcul c2 = new Calcul(9, aff);
        /* Step 5*/
        CalcRunnable cr1 = new CalcRunnable(c1);
        Thread t1 = new Thread(cr1, "T1");
        CalcRunnable cr2 = new CalcRunnable(c1);
        Thread t2 = new Thread(cr2, "T2");
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* STEP3: 2 Threads concurrents sur 2 objects calculs
        CalcRunnable cr1 = new CalcRunnable(c1);
        Thread t1 = new Thread(cr1);
        t1.setName("T1");
        CalcRunnable cr2 = new CalcRunnable(c2);
        Thread t2 = new Thread(cr2);
        t2.setName("T2");

        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /* Step 4: 2 Thread 1 by 1, 2 calculs
        CalcRunnable cr1 = new CalcRunnable(c1);
        Thread t1 = new Thread(cr1);
        t1.setName("T1");
        CalcRunnable cr2 = new CalcRunnable(c2);
        Thread t2 = new Thread(cr2);
        t2.setName("T2");
        try {
            t1.start();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("Fin du travail");
    }
}
