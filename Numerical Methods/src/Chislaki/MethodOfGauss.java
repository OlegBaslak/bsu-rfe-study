package Chislaki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by GPef on 19.09.2014.
 */
public class MethodOfGauss
{
    public static void main(String[] args) throws IOException
    {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Size: ");
        int n = Integer.parseInt(reader.readLine());*/
        int n = 1;
        //Matrix A
        double[][] a = new double[n][n];

        //Matrix B
        double[] b = new double[n];

        //Enter matrix A:
        //fillTheMatrix(a);

        //Enter matrix B:
        //fillTheMatrix(b);

        getRandom(a, b, n);

        //copy of matrix A and B
        //double[][] a1 = copyMatrix(a);

        //double[] b1 = copyMatrix(b);

        //Матрица исходная
        //print(a, b);

        Long t0 = System.currentTimeMillis();
        Gauss(a, b);

        //Матрица после преобразований
        //print(a, b);

        //Получение ответа
        double[] x = reverseGauss(a, b);

        Long t1 = System.currentTimeMillis();
        System.out.println("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024d) + " Mb.");
        System.out.println("Time: " + (t1 - t0) / 1000.0 + " sec.");
        /*//Решение
        showSolution(x);

        //Считаем вектор невязки
        double[] f = discrepancy(a1, b1, x);


        //Находим максимальный элемент
        double d = rate(f);

        System.out.println("d = " + d);*/

    }

    public static void fillTheMatrix(double[][] a) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(String.format("a[%d][%d]=", i, j));
                a[i][j] = Double.parseDouble(reader.readLine());
            }
        }
    }

    public static void fillTheMatrix(double[] b) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < b.length; i++) {
            System.out.print(String.format("a[%d]=", i));
            b[i] = Double.parseDouble(reader.readLine());
        }
    }

    public static double[][] copyMatrix(double[][] a) {
        double[][] k = new double[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, k[i], 0, a[i].length);
        }

        return k;
    }

    public static double[] copyMatrix(double[] b) {
        double[] k = new double[b.length];
        System.arraycopy(b, 0, k, 0, b.length);
        return k;
    }

    public static void print(double[][] a, double[] b) {
        System.out.println();
        for (int  i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(String.format("%-10.8s", a[i][j]));
            }
            System.out.println(String.format("|%-10.8s", b[i]));
        }
    }

    public static void Gauss(double[][] a, double[] b) {
        for (int i = 0; i < a.length; i++) {
            int rowMaxElem = rowMaxElem(a, i);
            if (rowMaxElem == -1) {
                System.out.println("Error!");
                System.exit(1);
            }
            if (rowMaxElem != i)
                exchange(a, b, i, rowMaxElem);		//Находим maxElem столбца и ставим его на главную диагоняль

            double mainElem = a[i][i];			//Опорный элемент

            for (int j = i; j < a[i].length; j++) {
                a[i][j] /= mainElem;		//Пересчитали коэффициенты строки
            }
            b[i] /= mainElem;		//Пересчитали свободный член строки

            for (int z = i + 1; z < a.length; z++) {
                double k = a[z][i];
                for (int x = i; x < a[z].length; x++) {
                    a[z][x] += a[i][x] * (-k);		//Пересчитали коэфициенты до конца строки
                }
                //Пересчитали свободный член
                b[z] += b[i] * (-k);
            }
        }
    }

    public static double[] reverseGauss(double[][] a, double[] b) {
        double[] x = new double[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            double rezalt = b[i];
            for (int j = a.length - 1; j > i; j--) {
                rezalt -= a[i][j] * x[j];
            }
            x[i] = rezalt;
        }
        return x;
    }

    public static int rowMaxElem(double[][] a, int k) {
        int max = k;
        for (int i = k + 1; i < a.length; i++) {
            if (Math.abs(a[i][k]) > Math.abs(a[max][k]))
                max = i;
        }
        if (a[max][k] == 0)
            return -1;
        return max;
    }

    public static void exchange(double[][] a, double[] b, int k, int l) {
        double[] e = a[k];
        a[k] = a[l];
        a[l] = e;

        double i = b[k];
        b[k] = b[l];
        b[l] = i;
    }

    public static void showSolution(double[] x) {
        System.out.print(System.lineSeparator() + "Solution : {");
        for (int i = 0; i < x.length; i++) {
            if (i != x.length - 1)
                System.out.print(x[i] + ", ");
            else
                System.out.print(x[i]);
        }
        System.out.println("}"+ System.lineSeparator());
    }

    public static double[] discrepancy(double[][] a, double[] b, double[] x) {
        double[] f = new double[x.length];

        for (int i = 0; i < a.length; i++) {
            f[i] = 0;
            for (int j = 0; j < a[i].length; j++) {
                f[i] += a[i][j] * x[j];
            }
            f[i] -= b[i];
        }

        return f;
    }

    public static double rate(double[] f) {
        double d = Math.abs(f[0]);
        for (int i = 1; i < f.length; i++) {
            if (Math.abs(f[i]) > d)
                d = Math.abs(f[i]);
        }
        return d;
    }

    public static void getRandom (double[][] a, double[] b, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Math.random() * 10;
            }
            b[i] = Math.random() * 10;
        }
    }
}
