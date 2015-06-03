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
        System.out.println("Regular polygon 3 sides");
        Shape rp1 = new RegularPolygon(10.0f, 3);
        printAreaOf(rp1);
        printPerimeterOf(rp1);
        System.out.println("Regular polygon 4 sides");
        Shape rp2 = new RegularPolygon(new Float(5 * Math.sqrt(2f) / 2), 4);
        printAreaOf(rp2);
        printPerimeterOf(rp2);
        System.out.println("Regular polygon 999 sides");
        Shape rp3 = new RegularPolygon(1f, 999);
        printAreaOf(rp3);
        printPerimeterOf(rp3);
        System.out.println(Math.PI * 2);
        try {
            Shape tr = new Triangle(0f, 1f, 2f);
        } catch (IllegalArgumentException e) {
            System.out.format("Erreur during creation of shape: %s\n"
                              + e.getMessage());
        }

    }

    /** Method to print in the console the Area of a Shape.
     * @param sh Shape to use.
     */
    public static void printAreaOf(final Shape sh) {
        System.out.println(String.format("L'aire est de %f",
                           sh.area()));
    }

    /** Method to print in the console the Perimeter of a Shape.
     * @param sh Shape to use.
     */
    public static void printPerimeterOf(final Shape sh) {
        System.out.println(String.format("Le périmètre est de %f",
                           sh.perimeter()));
    }

}
