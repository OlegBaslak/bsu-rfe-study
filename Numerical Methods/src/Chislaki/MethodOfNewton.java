package Chislaki;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by GPef on 20.09.2014.
 */

public class MethodOfNewton
{
    interface functions {
        double func(double[] x);
    }

    public static functions[] func = {
            new functions()
    {
        @Override
        public double func(double[] x)
        {
            return x[0]-MethodOfEilerN.y[0] - MethodOfEilerN.tau*(x[1]-(MethodOfEilerN.a*x[0])*x[0]);
            //return 2*Math.pow(x[0], 3) - Math.pow(x[1], 2) - 1;

        }
    },
            new functions()
    {
        @Override
        public double func(double[] x)
        {
            //return x[0]*Math.pow(x[1], 3) - x[1] - 4;
            return x[1]-MethodOfEilerN.y[1] - MethodOfEilerN.tau*(Math.exp(x[0])-(x[0]+MethodOfEilerN.a*x[1])*x[0]);

        }
    }};

    public static functions[][] dfunc= {
            {new functions()
            {
                @Override
                public double func(double[] x)
                {
                    //1-ое ур. 1 произв. по 1 перем.
                    //return 6*Math.pow(x[0], 2);
                    return 1 - MethodOfEilerN.tau*((-2)*x[0]*MethodOfEilerN.a - MethodOfEilerN.k * x[1]);
                }
            }, new functions()
            {
                @Override
                public double func(double[] x)
                {
                    //1 - ое ур. 1 произв. по 2 пермен.
                    //return -2*x[1];
                    return -MethodOfEilerN.tau * (1-MethodOfEilerN.k * x[0]);
                }
            }},
            {new functions()
            {
                @Override
                public double func(double[] x)
                {
                    //2-ое ур. 1 проивз по 1 перем.
                    //return Math.pow(x[1], 3);
                    return MethodOfEilerN.tau * (Math.exp(x[0]) - 2* x[0] - MethodOfEilerN.a * x[1]);
                }
            }, new functions()
            {
                @Override
                public double func(double[] x)
                {
                    //2-ое ур. 1 произв. по 2 пермен.
                    //return 3*x[0]*Math.pow(x[1], 2) - 1;
                    return 1- MethodOfEilerN.tau * (MethodOfEilerN.a * (-1) * x[0]);
                }
            }}
    };

  /*  public static double proizv(double[] x, functions[] functions)
    {
        double dx = 1e-6;
        double y1 = functions[0].func[x];
        x[0] += dx;
        return 0;
    }
*/



    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] x = new double[func.length];

        //Начальное приближение
        System.out.println("Введите x0:");
        for (int i = 0; i < x.length; i++) {
            x[i] = Double.parseDouble(reader.readLine());
        }

        //Количество итераций
        System.out.print("Число итераций: ");
        System.out.print("k = ");
        int k = Integer.parseInt(reader.readLine());

        //Точность
        System.out.println("Точность итераций: ");
        System.out.print("e1 = ");
        double e1 = Double.parseDouble(reader.readLine());
        System.out.print("e2 = ");
        double e2 = Double.parseDouble(reader.readLine());


        for (int i = 0; i < k; i++) {
            double[] F = discrepancy(x, func);
            double[][] J = Jacobian(x, dfunc);
            double[] cloneOfX = MethodOfGauss.copyMatrix(x);

            MethodOfGauss.Gauss(J, F);
            double[] dx = MethodOfGauss.reverseGauss(J, F);

            for (int j = 0; j < x.length; j++) {
                x[j] -= dx[j];
            }

            double d1 = MethodOfGauss.rate(discrepancy(x, func));
            double d2 = rate(x,cloneOfX);

            System.out.print("k= " + i);
            System.out.println("| d1=" + d1 + ", d2= " + d2);


            if (d1 < e1 && d2 < e2) {
                k = i;
                break;
            }

        }

        for (int i = 0 ; i < x.length; i++) {
            System.out.print(x[i] + "  ");
        }
     System.out.println("\n" + "k = " + k);



    }

    public static double[] MethodNewton(double y[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] x = new double[func.length];
        x = Arrays.copyOf(y, y.length);
        //Количество итераций
        int k = 10;
        //Точность
       // System.out.println("Точность итераций: ");
        double e1 = 1e-6;
        double e2 = 1e-6;


        for (int i = 0; i < k; i++) {
            double[] F = discrepancy(x, func);
            double[][] J = Jacobian(x, dfunc);
            double[] cloneOfX = MethodOfGauss.copyMatrix(x);

            MethodOfGauss.Gauss(J, F);
            double[] dx = MethodOfGauss.reverseGauss(J, F);

            for (int j = 0; j < x.length; j++) {
                x[j] -= dx[j];
            }

            double d1 = MethodOfGauss.rate(discrepancy(x, func));
            double d2 = rate(x,cloneOfX);

           // System.out.print("k= " + i);
           // System.out.println("| d1=" + d1 + ", d2= " + d2);


            if (d1 < e1 && d2 < e2) {
                k = i;
                break;
            }

        }

        for (int i = 0 ; i < x.length; i++) {
      //      System.out.print(x[i] + "  ");
        }
      //  System.out.println("\n" + "k = " + k);



        return x;
    }
    /**
     * Невязка
     */
    public static double[] discrepancy(double[] x, functions[] functions) {
        double[] f = new double[functions.length];
        for (int i = 0; i < functions.length; i++) {
            f[i] = functions[i].func(x);
        }
        return f;
    }

    /**
     * Якобиан
     */

    public static double[][] Jacobian (double[] x, functions[][] dfunctions) {
        double[][] J = new double[dfunctions.length][dfunctions[0].length];
        for (int i = 0; i < dfunctions.length; i++) {
            for (int j = 0; j < dfunctions[i].length; j++) {
                J[i][j] = dfunctions[i][j].func(x);
            }
        }
        return J;
    }

    /**
     *
     */
    public static double rate(double[] xN, double[] xF) {
        double[] d = new double[xN.length];
        for (int i = 0; i < xN.length; i++) {
            if (xN[i] > 1) {
                d[i] = Math.abs((xN[i] - xF[i])/xN[i]);
            }
            else {
                d[i] = Math.abs(xN[i] - xF[i]);
            }
        }
        return MethodOfGauss.rate(d);
    }

    /*public static double dt(double[] x, functions[] func)
    {
        double sum1 =0, sum2 = 0;
        double dx = 0.00001;
        for (int i = 0; i < func.length; i++)
        {
            sum1+=x[i];
            sum2+=
        }


    }*/
}

