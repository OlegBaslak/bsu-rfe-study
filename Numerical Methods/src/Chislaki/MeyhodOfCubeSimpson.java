package Chislaki;

/**
 * Created by Олег on 19.10.2014.
 */
public class MeyhodOfCubeSimpson {

    final private static double a = 3;
    final private static double b = 4;
    final private static double c = 1;
    final private static double d = 2;
    final private static int m = 100;
    final private static int n = m;
    private static double hx = (b - a) / (2 * n);
    private static double hy = (d - c) / (2 * m);
    private static double xi = a;
    private static double yi = c;

    public static double function(double x, double y) {
        return 1; // ((x + y) * (x + y));
    }

    public static void main(String args[]) {
        double integral = 0;
        double sum = 0;
        double[] Xi = new double[2 * m + 1];
        Xi[0] = xi;
        double[] Yi = new double[2 * n + 1];
        Yi[0] = yi;
        for (int i = 1; i <= 2 * n; i++) {
            Xi[i] = Xi[i - 1] + hx;
        }
        for (int j = 1; j <= 2 * m; j++) {
            Yi[j] = Yi[j - 1] + hy;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += function(Xi[2 * i], Yi[2 * j]);
                sum += 4 * function(Xi[2 * i + 1], Yi[2 * j]);
                sum += function(Xi[2 * i + 2], Yi[2 * j]);
                sum += 4 * function(Xi[2 * i], Yi[2 * j + 1]);
                sum += 16 * function(Xi[2 * i + 1], Yi[2 * j + 1]);
                sum += 4 * function(Xi[2 * i + 2], Yi[2 * j + 1]);
                sum += function(Xi[2 * i], Yi[2 * j + 2]);
                sum += 4 * function(Xi[2 * i + 1], Yi[2 * j + 2]);
                sum += function(Xi[2 * i + 2], Yi[2 * j + 2]);
            }
        }

/*        for (int i = 0; i <= n - 1; i +=2) {
            for (int j = 0; j <= m-1; j +=2) {
                sum += function(Xi[i], Yi[j]);
            }
        }

        for (int i = 1; i <= n - 1; i += 2) {
            for (int j = 0; j <= m-1; j += 2) {
                sum += 4 * function(Xi[i], Yi[j]);
            }
        }

        for (int i = 2; i <= n - 1; i += 2) {
            for (int j = 0; j <= m-1; j += 2) {
                sum += function(Xi[i], Yi[j]);
            }
        }


        for (int i = 0; i <= n - 1; i += 2) {
            for (int j = 1; j <= m-1; j += 2) {
                sum += 4 * function(Xi[i], Yi[j]);
            }
        }

        for (int i = 1; i <= n - 1; i += 2) {
            for (int j = 1; j <= m-1; j += 2) {
                sum += 16 * function(Xi[i], Yi[j]);
            }
        }

        for (int i = 2; i <= n - 1; i += 2) {
            for (int j = 1; j <= m-1; j += 2) {
                sum += 4 * function(Xi[i], Yi[j]);
            }
        }

        for (int i = 0; i <= n - 1; i += 2) {
            for (int j = 2; j <= m-1; j += 2) {
                sum += function(Xi[i], Yi[j]);
            }
        }

        for (int i = 1; i <= n - 1; i += 2) {
            for (int j = 2; j <= m-1; j += 2) {
                sum += 4 * function(Xi[i], Yi[j]);
            }
        }

        for (int i = 2; i <= n - 1; i += 2) {
            for (int j = 2; j <= m-1; j += 2) {
                sum += function(Xi[i], Yi[j]);
            }
        }
*/
        integral += sum;
        integral *= (hx * hy / 9);
        System.out.println("Integral by CubeOfSimpson= " + integral);    //0.040822
    }
}

