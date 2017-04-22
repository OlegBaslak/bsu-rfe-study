package menuBars;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    public static int flagRow;
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    private String[] ColomNames = new String[]{"Значение X", "Значение многочлена", "float значение многочлена", "Разница между double и float"};

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    private double MethodOfGorner(double x) {
        int n = coefficients.length - 1;
        double y = coefficients[n];
        for (int i = n - 1; i >= 0; i--) {
            y = x * y + coefficients[i];
        }
        return y;
    }

    private float MethodOfGorner(float x) {
        int n = coefficients.length - 1;
        float y = Float.valueOf(String.valueOf(coefficients[n]));
        for (int i = n - 1; i >= 0; i--) {
            y = x * y + Float.valueOf(String.valueOf(coefficients[i]));
        }
        return y;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return new Double(Math.ceil((to - from) / step)).intValue() + 1;
    }

    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        float xf = (float) (from + step * row);
        if (col == 0) {
            return x;
        } else {
            if (col == 1) return MethodOfGorner(x);
            else if (col == 2) return MethodOfGorner(xf);
            else
                return Float.valueOf(String.valueOf(getValueAt(row, 1))) - Float.valueOf(String.valueOf(getValueAt(row, 2)));
        }


    }

    public String getColumnName(int col) {
        return ColomNames[col];
    }

    public Class<?> getColumnClass(int col) {
        switch (col) {
            /*case 2:
                return Float.class;*/
            default:
                return Double.class;
        }

    }

}
