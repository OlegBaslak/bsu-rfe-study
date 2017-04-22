package EasyGeometry;

/**
 * @author Oleg Baslak
 * @version 1.0
 * @since JDK 1.0
 */

public class Triangle extends Figure {

    private double sideA;
    private double sideB;
    private double sideC;
    private double height;


    @Override
    public double GetPerimetr() {
        return sideA + sideB + sideC;
    }

    @Override
    public double GetSquare() {
        return GeronsMethod();
    }

    private double GeronsMethod() {
        double p = GetPerimetr() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    /**
     * Checks if triangle exists with curtain sides
     *
     * @return true, if triangle exists
     */
    private boolean IsExists() {
        if ((sideA + sideB < sideC) && (sideA + sideC < sideB) && (sideC + sideB < sideA)) {
            return true;
        } else
            return false;
    }
}
