package foodLab;

/**
 * Created by Олег on 24.09.2014.
 */

public class Cheese extends Food{
    private String name;
    private double calories;

    public Cheese(String name) {
        super("Cheese");
        this.name = name;
        this.calories = 250;
    }

    Comparable<Integer> paramsCount = 2;

    @Override
    public void consume() {
        System.out.println("Сыр съеден");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cheese cheese = (Cheese) o;

        if (Double.compare(cheese.calories, calories) != 0) return false;
        if (name != null ? !name.equals(cheese.name) : cheese.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(calories);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public double calculateCalories()
    {
        System.out.println("Сыр калорийностью " + calories);
        return calories;
    }
}
