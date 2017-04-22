package foodLab;

/**
 * Created by Олег on 24.09.2014.
 */

public class Apple extends Food {

    private String size;
    private String name;
    private double calories;
    Comparable<Integer> paramsCount = 3;

    public Apple(String name, String size) {
        super("Apple");
        this.name = name;
        this.size = size;
        if (this.size == "small")
        {
            this.calories = 100;
        }
        else
            if (this.size == "medium")
            {
                this.calories = 150;
            }
            else
                if (this.size == "large")
                {
                    this.calories = 200;
                }
        else this.calories = 50;

    }

    @Override
    public void consume() {
        System.out.println("Яблоко съедено");
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Apple apple = (Apple) o;

        if (Double.compare(apple.calories, calories) != 0) return false;
        if (name != null ? !name.equals(apple.name) : apple.name != null) return false;
        if (size != null ? !size.equals(apple.size) : apple.size != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = size != null ? size.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(calories);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public double calculateCalories()
    {
        System.out.println("Яблоко калорийностью " + calories);
        return calories;
    }

    public String toString() {
         return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}

