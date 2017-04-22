package Chislaki;


/**
 * Created by Олег on 20.10.2014.
 */
public class MethodMNK {
    public static int n = 11;
    public static int N = 11;
    public static int m = 2;

    public static void showArray(double[] array, String name) {
        System.out.println("Массив: " + name);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void showArray(double[][] array, String name) {
        System.out.println("Массив: " + name);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        double[] Xi = new double[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] Yi = new double[]{3, 87, 156, 210, 238, 252, 239, 211, 158, 90, -5};

        double[] POWERX = new double[2 * m];
        double[][] SUMX = new double[m + 1][m + 1];
        double[] PRAW = new double[m + 1];
        double[] a_coef = new double[m + 1];

        SUMX[0][0] = N;

        for (int k = 1; k <= 2 * m; k++) {
            for (int i = 1; i <= N; i++) {
                POWERX[k - 1] += Math.pow(Xi[i - 1], k);
            }

        }

        for (int l = 0; l < m + 1; l++)
            for (int j = 0; j < m + 1; j++) {
                if (l == 0 && j == 0) {
                    SUMX[l][j] = N;
                } else
                    SUMX[l][j] = POWERX[l + j - 1];
            }
        showArray(SUMX, "Матрица коэффициентов");

        for (int l = 1; l <= m + 1; l++) {
            for (int i = 1; i <= N; i++) {
                PRAW[l - 1] += Yi[i - 1] * Math.pow(Xi[i - 1], l - 1);
            }
        }
        showArray(PRAW, "Правый столбец(свободные члены)");
        showArray(POWERX, "Суммы степеней икса");
        MethodOfGauss.print(SUMX, PRAW);
        MethodOfGauss.Gauss(SUMX, PRAW);
        a_coef = MethodOfGauss.reverseGauss(SUMX, PRAW);
        showArray(a_coef, "Решенная система по Гауссу");
        double s = 0;
        double sum1 = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum1 = Yi[i] - a_coef[0];
            for (int j = 1; j <= m; j++) {

                sum1 -= a_coef[j] * Math.pow(Xi[i], j);
            }
            sum1 *= sum1;
            sum += sum1;
        }
        s += (1.0 / (N - m - 1)) * sum;

        for (int i = 0; i < N; i++)
        {
            System.out.println(a_coef[0] + Xi[i]*a_coef[1] + Xi[i]*Xi[i]*a_coef[2] + " | " + Yi[i]);
        }

        System.out.println("Дисперсия: " + s);
        System.out.println("Среднеквадратичное отклонение: " + Math.sqrt(s));
    }
}