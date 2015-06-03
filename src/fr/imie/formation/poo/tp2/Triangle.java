package fr.imie.formation.poo.tp2;

/** Class representing a Triangular shape.
 * @author Florent RICHARD
 */
public class Triangle extends Shape {

    /** First side of triangle.
     */
    private Float side1;
    /** Second side of triangle.
     */
    private Float side2;
    /** Third side of triangle.
     */
    private Float side3;

    /** Constructor.
     * @param s1 First side of the triangle.
     * @param s2 Second side of the triangle.
     * @param s3 Third side of the triangle.
     */
    public Triangle(final Float s1, final Float s2, final Float s3) {
        super();
        setSides(s1, s2, s3);
    }

    /**
     * @see fr.imie.formation.poo.tp2.Shape#area()
     */
    @Override
    public final Float area() {
        // TODO Auto-generated method stub
        Float p = perimeter() / 2.0f;
        return (float)
                Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    /**
     * @see fr.imie.formation.poo.tp2.Shape#perimeter()
     */
    @Override
    public final Float perimeter() {
        return side1 + side2 + side3;
    }

    /** Accessor to the side1.
     * @return the side1
     */
    public final Float getSide1() {
        return side1;
    }

    /** Accessor to the side2.
     * @return the side2
     */
    public final Float getSide2() {
        return side2;
    }

    /** Accessor to the side3.
     * @return the side3
     */
    public final Float getSide3() {
        return side3;
    }

    /** Mutator for the 3 sides.
     * @param s1 the side1 to set
     * @param s2 the side2 to set
     * @param s3 the side3 to set
     * @throws IllegalArgumentException case where the side is not positive
     *         Or size of the 3 sides are not coherent.
     */
    public final void setSides(final Float s1, final Float s2, final Float s3)
        throws IllegalArgumentException {
        if ((s1 + s2 < s3) || (s2 + s3 < s1) || (s3 + s1 < s2)) {
            throw new IllegalArgumentException("Valeurs des côtés incorrects");
        } else if ((s3 <= 0) || (s2 <= 0) || (s1 < 0)) {
            throw new IllegalArgumentException("Un côté doit être positif");
        } else {
            side1 = s1;
            side2 = s2;
            side3 = s3;
        }
    }
}
