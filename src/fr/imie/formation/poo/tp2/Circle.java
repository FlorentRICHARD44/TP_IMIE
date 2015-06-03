package fr.imie.formation.poo.tp2;

/** Class representing a circular shape.
 * @author Florent RICHARD
 */
public class Circle extends Shape {
    /** Radius of the circle.
     */
    private Float radius;

    /** Constructor.
     * @param r radius of the circle.
     */
    public Circle(final Float r) {
        setRadius(r);
    }

    /**
     * @see fr.imie.formation.poo.tp2.Shape#area()
     */
    @Override
    public final Float area() {
        // TODO Auto-generated method stub
        return (float) (Math.PI * Math.pow(this.radius, 2));
    }

    /**
     * @see fr.imie.formation.poo.tp2.Shape#perimeter()
     */
    @Override
    public final Float perimeter() {
        // TODO Auto-generated method stub
        return (float) (Math.PI * 2 * this.radius);
    }

    /** Accessor to the radius.
     * @return the radius
     */
    public final Float getRadius() {
        return radius;
    }

    /** Mutator for the radius.
     * @param r the radius to set
     */
    public final void setRadius(final Float r) {
        this.radius = r;
    }
}
