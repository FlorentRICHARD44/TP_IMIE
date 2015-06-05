package fr.imie.formation.poo.tp2;


/** Class representing a Regular Polygon.
 * @author Florent RICHARD
 *
 */
public class RegularPolygon extends Shape {
    /** Radius of the Polygon.
     */
    private Float radius;
    /** Side of the Polygon.
     */
    private Float side;
    /** Number of side of the Polygon.
     */
    private Integer nbSide;
    /** Constructor.
     * @param r Radius of the shape.
     * @param n Number of side of the shape.
     */
    public RegularPolygon(final Float r, final Integer n) {
        super();
        setNbSide(n);
        setRadius(r);
        setSide();
    }

    /**
     * @see fr.imie.formation.poo.tp2.Shape#area()
     */
    @Override
    public final Float area() {
        Shape sh = new Triangle(radius, radius, side);
        return new Float(sh.area() * nbSide);
    }

    /**
     * @see fr.imie.formation.poo.tp2.Shape#perimeter()
     */
    @Override
    public final Float perimeter() {
        return nbSide * side;
    }

    /** Accessor for the radius.
     * @return the radius
     */
    public final Float getRadius() {
        return radius;
    }

    /** Mutator for the radius.
     * @param r the radius to set
     * @throws IllegalArgumentException Case where the radius is not positive.
     */
    public final void setRadius(final Float r) throws IllegalArgumentException {
        if (r > 0) {
            this.radius = r;
        } else {
            throw new IllegalArgumentException("The radius shall be positive");
        }
    }

    /** Accessor for the side.
     * @return the side
     */
    public final Float getSide() {
        return side;
    }

    /** Mutator for the side.
     */
    public final void setSide() {
        this.side = new Float(2 * radius * Math.sin(Math.PI / nbSide));
    }

    /** Accessor for the number of sides.
     * @return the nbSide
     */
    public final Integer getNbSide() {
        return nbSide;
    }

    /** Mutator for the number of sides.
     * @param n the nbSide to set
     * @throws IllegalArgumentException case
     *         where the number of side is incorrect.
     */
    public final void setNbSide(final Integer n)
            throws IllegalArgumentException {
        if (n > 2) {
            this.nbSide = n;
        } else {
            throw new IllegalArgumentException(
                    "A Regular Polygon shall have at least 3 sides.");
        }
    }

}
