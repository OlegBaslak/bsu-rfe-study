package Chislaki;

import java.lang.Math;
import java.util.Scanner;

/**
 * Created by Олег on 05.10.2014.
 */
public class MethodOfEiler {
    final public static double a = 2;
    final public static double k = 0.25;
    final public static double U10 = 1;
    final public static double U20 = 0;
    final public static double t0 = 0;
    final public static double T = 1;
    final public static double eps = 1e-3;
    final public static double taumax = T;
    public static int iterCount;


    public static double func1(double y[]) {
        return y[1] - (MethodOfEiler.a * y[0] + MethodOfEiler.k * y[1]) * y[0];
    }

    public static double func2(double y[]) {
        return Math.exp(y[0]) - (y[0] + MethodOfEiler.a * y[1]) * y[0];
    }


    public static void main(String[] args) {
       MethodEilerN();
    }


    public static void MethodEilerN()
    {
        MethodOfEiler.iterCount = 0;
        Scanner scanner = new Scanner(System.in);
        final int n = 2;
        double tk = t0;
        double taumin;

        double[] y = new double[]{U10, U20};
        double[] vector = new double[2];
        double[] shag = new double[]{eps / (Math.abs(vector[0]) + eps / taumax), eps / (Math.abs(vector[1]) + eps / taumax)};

        System.out.println("y[0]                    |          y[1]                    |          tk          ");
        System.out.println(y[0] + "     " + y[1] + "        " + tk);


        while (tk < T) {
            //Считаем вектор f
            vector[0] = func1(y);
            vector[1] = func2(y);
            //Пересчет taumin (шаг)
            shag[0] = eps / (Math.abs(vector[0]) + eps / taumax);
            shag[1] = eps / (Math.abs(vector[1]) + eps / taumax);
            taumin = shag[0]*0.09;
            if (taumin > shag[1]) taumin = shag[1];
            //Выполняем шаг
            y[0] = y[0] + taumin * vector[0];
            y[1] = y[1] + taumin * vector[1];
            tk += taumin;
            //Выводим
            System.out.print("y[0] = " + y[0] + " | ");
            System.out.print("y[1] = " + y[1] + " | ");
            System.out.println("tk = " + tk);
            iterCount++;

        }
        System.out.print(iterCount);
        scanner.close();
    }
}