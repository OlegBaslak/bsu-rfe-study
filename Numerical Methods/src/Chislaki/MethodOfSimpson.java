package Chislaki;

/**
 * Created by Олег on 19.10.2014.
 */
public class MethodOfSimpson {
    final private static double a = 0.6;
    final private static double b = 1.724;
    private static double m = 2;
    private static double n = 2 * m;
    final private static double eps = 1e-6;
    private static double h = (b - a) / n;
    private static double xi = a;
    public static int iterCount=0;

    public static double function(double x) {
        return x*x*x;//Math.sqrt(x + x * x * x);
    }

    public static void MethodSimpson()
    {
        double integral=0;
        double integralprev = 0;
        double sum = 0;

        do {
            MethodOfSimpson.iterCount++;
            integral = function(a) + function(b);
            xi = a;
            sum = 0;
            for (int i = 1; i < n; i++) {
                xi += h;
                if (i % 2 != 0) {
                    sum += 4 * function(xi);
                } else if (i % 2 == 0) {
                    sum += 2 * function(xi);
                }
            }
            integral += sum;
            integral*=h/3;
            ///////
            h/=2;
            n*=2;

            integralprev = function(a) + function(b);
            xi = a;
            sum = 0;
            for (int i = 1; i < n; i++) {
                xi += h;
                if (i % 2 != 0) {
                    sum += 4 * function(xi);
                } else if (i % 2 == 0) {
                    sum += 2 * function(xi);
                }
            }
            integralprev += sum;
            integralprev*=h/3;


        }
        while(Math.abs(integral - integralprev) >= eps * 15);

        System.out.println("Integral by Simpson = " + integral + " Итераций: " + iterCount);
    }



    public static void main(String[] args) {
        double integral=0;
        double integralprev = 0;
        double sum = 0;

        do {
            integral = function(a) + function(b);
            xi = a;
            sum = 0;
            for (int i = 1; i < n; i++) {
                xi += h;
                if (i % 2 != 0) {
                    sum += 4 * function(xi);
                } else if (i % 2 == 0) {
                    sum += 2 * function(xi);
                }
            }
            integral += sum;
            integral*=h/3;
            ///////

            integralprev = function(a) + function(b);
            xi = a;
            sum = 0;
            for (int i = 1; i < n; i++) {
                xi += h;
                if (i % 2 != 0) {
                    sum += 4 * function(xi);
                } else if (i % 2 == 0) {
                    sum += 2 * function(xi);
                }
            }
            integralprev += sum;
            integralprev*=h/3;

            h/=2;
        }
        while(Math.abs(integral - integralprev) >= eps * 15);

        System.out.println("Integral by Simpson= " + integral);
//      System.out.println("1.89818");
    }

}
