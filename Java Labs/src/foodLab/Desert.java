package foodLab;

import foodLab.Food;

/**
 * Created by Олег on 24.09.2014.
 */

public class Desert extends Food {
    private String size;
    private String name;
    private String ingred1;
    private String ingred2;
    private double calories;

    Comparable<Integer> paramsCount = 5;

    public Desert(String name, String size, String ingred1, String ingred2) {
        super("Desert");
        this.name = name;
        this.size = size;
        this.ingred1 = ingred1;
        this.ingred2 = ingred2;
        this.calories = Double.parseDouble(size) * 1.754;
    }

    public String getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Desert desert = (Desert) o;

        if (Double.compare(desert.calories, calories) != 0) return false;
        if (!ingred1.equals(desert.ingred1)) return false;
        if (!ingred2.equals(desert.ingred2)) return false;
        if (!name.equals(desert.name)) return false;
        if (!size.equals(desert.size)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = size.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + ingred1.hashCode();
        result = 31 * result + ingred2.hashCode();
        temp = Double.doubleToLongBits(calories);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public void setup() {
        System.out.println("Состав десерта: ");
        System.out.println("- " + ingred1);
        System.out.println("- " + ingred2);
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void consume() {
        System.out.println("Десерт на " + size + " гр с " + ingred1 + " и " + ingred2 + " съеден");
    }

    @Override
    public double calculateCalories() {
        System.out.println("Десерт калорийностью " + calories);
        return calories;
    }

}
