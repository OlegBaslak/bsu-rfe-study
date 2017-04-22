package foodLab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by Олег on 24.09.2014.
 */

public class MainClass {
    public static void main(String[] args) throws Exception
    {
        int nubOfProd = 20;
        Food[] breakfast = new Food[nubOfProd];

        //Class Food = Class.forName("foodLab.Food");
        Class Cheese= Class.forName("foodLab.Cheese");
        Class Apple = Class.forName("foodLab.Apple");
        Class Desert = Class.forName("foodLab.Desert");

        Constructor constructorCh = Cheese.getConstructor(String.class);
        Constructor constructorAp = Apple.getConstructor(String.class, String.class);
        Constructor constructorDsrt = Desert.getConstructor(String.class, String.class, String.class, String.class);

        int itemsSorted=0;

        for(String arg: args)
        {
            String[] foodParts = arg.split("/");
            if (foodParts[0].equals("Cheese"))
            {
                breakfast[itemsSorted] = (foodLab.Cheese) constructorCh.newInstance(foodParts[0]);
                //breakfast[itemsSorted] = new Cheese(foodParts[0]);

            }

            else
                if (foodParts[0].equals("Apple"))
                {
                    breakfast[itemsSorted] = (foodLab.Apple) constructorAp.newInstance(foodParts[0], foodParts[1]);
                    //breakfast[itemsSorted] = new Apple(foodParts[0], foodParts[1]);

                }

            else
                if (foodParts[0].equals("Desert"))
                {
                    breakfast[itemsSorted] = (foodLab.Desert) constructorDsrt.newInstance(foodParts[0], foodParts[1], foodParts[2], foodParts[3]);
                    //breakfast[itemsSorted] = new Desert(foodParts[0], foodParts[1], foodParts[2], foodParts[3]);
                }

            itemsSorted++;
        }

        Arrays.sort(breakfast, new Comparator() {
            public int compare(Object f1, Object f2) {
                if (f1 == null) return 1;
                if (f2 == null) return -1;
                Comparable<Integer> cp1 = ((Food) f1).getParamsCount();
                Comparable<Integer> cp2 = ((Food) f2).getParamsCount();
                return cp1.compareTo((Integer) cp2);
            }
        });

        double calories=0;
        for (Food item: breakfast)
            if (item!=null) {
                item.consume();
                calories+=item.calculateCalories();
            }
            else break;
        System.out.println("Общая калорийность:"+calories);
        System.out.println("Всего хорошего!");
    }
}



