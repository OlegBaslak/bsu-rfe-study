package EasyGeometry;

/**
 * @author Oleg Baslak
 * @version 1.0
 * @since JDK 1.6
 */

public class Rectangle extends Figure {

    private double sideA;
    private double sideB;

    /**
     * Constructs <code>Rectangle</code> with curtain sides
     *
     * @param a Length of a side
     * @param b Length of b side
     */
    public Rectangle(double a, double b) {
        sideA = a;
        sideB = b;
    }

    @Override
    public double GetPerimetr() {
        return (sideA + sideB) * 2;
    }

    @Override
    public double GetSquare() {
        return sideA * sideB;
    }
}
