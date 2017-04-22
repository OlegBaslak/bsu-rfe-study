package EasyGeometry;

/**
 * @author Oleg Baslak
 * @version 1.0
 */

public class Ellipse extends Figure {


    private double equationBig;
    private double equationLittle;

    /**
     * Constructs <code>Ellipse</code> with curtain equations
     *
     * @param a big equation of ellipse
     * @param b little equation of ellipse
     */
    public Ellipse(double a, double b) {
        equationBig = a;
        equationLittle = b;
    }

    @Override
    public double GetPerimetr() {
        return Math.PI * (equationLittle + equationBig);
    }

    @Override
    public double GetSquare() {
        return equationBig * equationLittle * Math.PI;
    }
}
