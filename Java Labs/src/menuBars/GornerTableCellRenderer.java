package menuBars;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private String needle = null;
    private static boolean polyFlag = false;
    public static boolean searchFlag = false;
    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();

    /*
    * Ищем ячейки, строковое представление которых совпадает с needle
    * (иголкой). Применяется аналогия поиска иголки в стоге сена, в роли
    * стога сена - таблица
    */
    public GornerTableCellRenderer() {
        formatter.setMaximumFractionDigits(10); // Показывать только 5 знаков после запятой
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }



    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);
        GornerTableModel.flagRow=row;
        if (col == 1 && needle != null && needle.equals(formattedDouble)) {
            //panel.setBackground(Color.RED);
            label.setIcon(new ImageIcon("src\\menuBars\\1.PNG"));


            System.out.println(value);
            System.out.print(table.getValueAt(row, col) + " значение");
        } else {
            panel.setBackground(Color.WHITE);
            label.setIcon(null);
        }
        if (isSelected) panel.setBackground(new Color(117, 144, 174));
        if (col == 1 && polyFlag) {
            StringBuilder temp = new StringBuilder(formattedDouble.toString());
            int pointPlace = temp.lastIndexOf(".");
            if (pointPlace != -1) {
                temp.replace(temp.lastIndexOf("."), temp.lastIndexOf(".") + 1, "");
            }
            int minusPlace = temp.lastIndexOf("-");
            if (minusPlace!= -1)
            {
                temp.replace(temp.lastIndexOf("-"), temp.lastIndexOf("-")+1, "");
            }
            System.out.print(temp + "=temp" + " || ");
            String temp1 = new String(temp);
            StringBuilder tempRev = new StringBuilder(temp.reverse());
            System.out.println(tempRev + "=revtemp;");
            if (Double.parseDouble(temp1.toString()) == Double.parseDouble(tempRev.toString())) {
                panel.setBackground(Color.GREEN);
                System.out.println(temp + " and " + tempRev + " polys");
            }
        }
        return panel;

    }

    public void setNeedle(String needle) {
        this.needle = needle;
    }

    public void setPolyFlag(boolean b) {
        this.polyFlag = b;
    }

    public static boolean isPolyFlag() {
        return polyFlag;
    }
}