package foodLab;

/**
 * Created by Олег on 24.09.2014.
 */

public  abstract class Food implements Consumable, Nutritious{
    String name = null; // Наименование продукта
    Comparable<Integer> paramsCount = 0;

    public Food(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food))
            return false;
        if (name==null || ((Food)arg0).name==null)
            return false;
        return name.equals(((Food)arg0).name);
    }

    @Override
    public void consume() {
     // TODO Auto-generated method stub
    }

    @Override
    public double calculateCalories(){
        return 0;
    }


    public Comparable<Integer> getParamsCount() {
        if (this.name.equals("Cheese")) return 2;
        if (this.name.equals("Apple")) return 3;
        if (this.name.equals("Desert")) return 5;

        return paramsCount;
    }
}

