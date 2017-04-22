package Chislaki;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Олег on 07.10.2014.
 */
public class MethodOfEilerN {
    final public static double a = 2;
    final public static double k = 0.25;
    final public static double U10 = 0;
    final public static double U20 = 0;
    final public static double t0 = 0;
    final public static double T = 1;
    final public static double eps = 10e-3;
    public static double epsk[] = {0, 0};
    final public static double taumin = 10e-1;
    public static double tau = taumin;
    public static double tauprev = taumin;
    public static double taunext = taumin;
    final public static double taumax = T;
    public static double tk = t0;
    public static double tk1 = t0;
    public static int iterCount;
    public static double[] y = new double[]{U10, U20};
    public static double[] yprev = new double[]{U10, U20};
    public static double[] ynext = new double[]{U10, U20};

    public static double func1(double y[]) {
        return y[0] - (MethodOfEilerN.a * y[0] + MethodOfEilerN.k * y[1]);
    }

    public static double func2(double y[]) {
        return Math.exp(y[0]) - (y[0] + MethodOfEilerN.a * y[1]);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        final int n = 2;
        MethodOfEilerN.iterCount = 0;
        System.out.println("y(k+1)[0]                    |          y(k+1)[1]                    |          t(k+1)          ");
        while (tk < T) {
                tk1 = tk + tau;
                ynext = Arrays.copyOf(MethodOfNewton.MethodNewton(ynext), n);
                boolean flagEps = false;
                for (int i = 0; i < n; i++) {
                    epsk[i] = -(tau / (tau + tauprev)) * (ynext[i] - y[i] - tau / tauprev * (y[i] - yprev[i]));
                    if (Math.abs(epsk[i]) > eps) flagEps = true;
                }

                if (flagEps) {
                    tau /= 2;
                    tk1 = tk;
                    ynext = Arrays.copyOf(y, n);
                } else {
                    taunext = Math.min(Math.sqrt(eps / Math.abs(epsk[0])) * tau, Math.sqrt(eps / Math.abs(epsk[1])) * tau);
                    if (taunext > taumax) taunext = taumax;
                    yprev = Arrays.copyOf(y, n);
                    y = Arrays.copyOf(ynext, n);
                    tauprev = tau;
                    tau = taunext;
                    tk = tk1;
                    //Выводим
                    System.out.print(ynext[0] + " | ");
                    System.out.print(ynext[1] + " | ");
                    System.out.println(tk1);
                }

                flagEps = false;
                iterCount++;

            }
            System.out.println(ynext[0] + " " + ynext[1]);
            System.out.println(iterCount);
            scanner.close();
        }
    }
