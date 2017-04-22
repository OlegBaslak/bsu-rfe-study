package Chislaki;

/**
 * Created by Олег on 19.10.2014.
 */

//1.89818
public class MethodOfTrap {
    final private static double a = 0.6;
    final private static double b = 1.724;
    private static double n = 1;
    final private static double eps = 1e-6;
    private static double h = (b - a) / n;
    private static double xi = a;
    public static int iterCount = 0;


    public static double function(double x) {
        return x*x*x;//Math.sqrt(x + x * x * x);
    }


    public static void main(String[] args) {
        double integral = 0;
        double integralprev = 0;
        double sum = 0;

        do {

            iterCount++;

            integral = function(a) + function(b);
            xi = a;
            sum = 0;
            for (int i = 1; i < n; i++) {
                xi += h;
                sum += 2 * function(xi);
            }
            integral += sum;
            integral *= h / 2;

            h /= 2;
            n*=2;

            integralprev = function(a) + function(b);
            xi = a;
            sum = 0;
            for (int i = 1; i < n; i++) {
                xi += h;
                sum += 2 * function(xi);
            }
            integralprev += sum;
            integralprev *= h / 2;


        }
        while (Math.abs(integral - integralprev) >= eps * 3);

        System.out.println("Integral by Trapecii= " + integral + "Итераций: " + iterCount);
        MethodOfSimpson.MethodSimpson();
//      System.out.println("1.89818");
    }
}
