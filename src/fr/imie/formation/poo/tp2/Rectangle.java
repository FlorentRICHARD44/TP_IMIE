package fr.imie.formation.poo.tp2;

/** Class representing a Rectangular Shape.
 * @author Florent RICHARD
 *
 */
public class Rectangle extends Shape {
    /** Width of the rectangle.
     */
    private Float width;
    /** Height of the rectangle.
     */
    private Float height;

    /** Constructor.
     * @param w Width of the Rectangle.
     * @param h Height of the Rectangle.
     */
    public Rectangle(final Float w, final Float h) {
        setWidth(w);
        setHeight(h);
    }

    /**
     * @see fr.imie.formation.poo.tp2.Shape#area()
     */
    @Override
    public final Float area() {
        // TODO Auto-generated method stub
        return this.height * this.width;
    }

    /**
     * @see fr.imie.formation.poo.tp2.Shape#perimeter()
     */
    @Override
    public final Float perimeter() {
        // TODO Auto-generated method stub
        return this.height * 2 + this.width * 2;
    }

    /** Accessor to the width.
     * @return the width
     */
    public final Float getWidth() {
        return width;
    }

    /** Mutator to the width.
     * @param w the width to set
     */
    public final void setWidth(final Float w) {
        this.width = w;
    }

    /** Accessor to the height.
     * @return the height
     */
    public final Float getHeight() {
        return height;
    }

    /** Mutator to the height.
     * @param h the height to set
     */
    public final void setHeight(final Float h) {
        this.height = h;
    }

}
