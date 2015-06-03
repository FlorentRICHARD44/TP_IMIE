package fr.imie.formation.poo.tp2;

/** Class used for testing the Shapes.
 * @author Florent RICHARD
 */
public final class ShapeTest {

    /** Constructor.
     * Not used.
     */
    private ShapeTest() {
    }

    /** Main function of the program.
     * @param args Application arguments.
     */
    public static void main(final String[] args) {
        Shape myRec = new Rectangle(10.0f, 20.0f);
        System.out.println("Rectangle");
        printAreaOf(myRec);
        printPerimeterOf(myRec);
        Shape mySqu = new Square(10.0f);
        System.out.println("Square");
        printAreaOf(mySqu);
        printPerimeterOf(mySqu);
        System.out.println("Circle");
        Shape myCir = new Circle(10.0f);
        printAreaOf(myCir);
        printPerimeterOf(myCir);
        System.out.println("Triangle");
        Shape myTri = new Triangle(3.0f, 4.0f, 5.0f);
        printAreaOf(myTri);
        printPerimeterOf(myTri);

    }

    /** Method to print in the console the Area of a Shape.
     * @param sh Shape to use.
     */
    public static void printAreaOf(final Shape sh) {
        System.out.println(String.format("L'aire est de %f",
                           sh.area()));
    }

    /** Method to print in the console the Permiter of a Shape.
     * @param sh Shape to use.
     */
    public static void printPerimeterOf(final Shape sh) {
        System.out.println(String.format("Le périmètre est de %f",
                           sh.perimeter()));
    }

}
