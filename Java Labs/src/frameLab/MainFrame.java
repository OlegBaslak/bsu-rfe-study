package frameLab;

/**
 * Created by Олег on 12.10.2014.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {
    // Переменные для кнопок MC и M+
    private static double mem1 = 0;
    private static double mem2 = 0;
    private static double mem3 = 0;


    // Размеры окна приложения в виде констант
    private static final int WIDTH = 1366;
    private static final int HEIGHT = 768;

    // Текстовые поля для считывания значений переменных, как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;


    ImagePanel formulaImagePanel = new ImagePanel();
    private JTextField param1;
    private JTextField param2;
    private JTextField param3;

    private JTextField textFieldResult;    // Текстовое поле для отображения результата, как компонент, совместно используемый в различных методах
    private JTextField textMem1;
    private JTextField textMem2;
    private JTextField textMem3;

    private ButtonGroup radioButtons = new ButtonGroup();
    private ButtonGroup radioParamsButtons = new ButtonGroup(); // Группа радио-кнопок для обеспечения уникальности выделения в группе

    private Box hboxFormulaType = Box.createHorizontalBox();
    private Box hRadioParams = Box.createHorizontalBox(); // Контейнер для отображения радио-кнопок
    private int formulaId = 1;
    private int paramId = 1;

    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y, Double z) {
        return (Math.sin(Math.PI * y * y) + Math.log(y * y)) / (Math.sin(Math.PI * z * z) + Math.sin(x) + Math.log(z * z) + x * x + Math.exp(Math.cos(z * x)));
    }

    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y, Double z) {
        return (Math.pow((Math.cos(Math.exp(y)) + Math.exp(y * y)) + Math.sqrt(1 / x), 0.25)) / Math.pow(Math.cos(Math.PI * z * z * z) + Math.log((1 + z) * (1 + z)), Math.sin(y));
    }

    // Вспомогательный метод для добавления кнопок на панель
    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        button.addActionListener(this);
        hboxFormulaType.add(button);
    }

    private void addRadioParams(String buttonName, final int paramId) {
        JRadioButton rbutton = new JRadioButton(buttonName);
        radioParamsButtons.add(rbutton);
        rbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.paramId = paramId;
            }
        });
        radioParamsButtons.add(rbutton);
        rbutton.addActionListener(this);
        hRadioParams.add(rbutton);
    }

    public void actionPerformed(ActionEvent e) {
        // Изменение заголовка окна в зависимости от выбранной радиокнопки.
        if (e.getActionCommand().equals("Формула 1") || (e.getActionCommand().equals("Формула 2"))) {
            setTitle("Выбрана " + e.getActionCommand());

            try {
                if (e.getActionCommand().equals("Формула 1")) {
                    formulaImagePanel.setLayout(new BorderLayout());
                    formulaImagePanel.setImage(ImageIO.read(new File("E:\\WORK\\WORKSPACES\\intellij\\lab1\\res\\frameLab\\formula1.png")));
                    formulaImagePanel.repaint();
                } else {
                    formulaImagePanel.setLayout(new BorderLayout());
                    formulaImagePanel.setImage(ImageIO.read(new File("E:\\WORK\\WORKSPACES\\intellij\\lab1\\res\\frameLab\\formula2.png")));
                    formulaImagePanel.repaint();
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("Параметр 1") || (e.getActionCommand().equals("Параметр 2")) || (e.getActionCommand().equals("Параметр 3"))) {
            setTitle("Выбран " + e.getActionCommand());
        }


    }

    public MainFrame() {
        super("Вычисление выражения по формуле");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();

        // Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);

        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        // Создать область с полями ввода для X и Y
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("1", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());

        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("1", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());

        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("1", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        Box hboxVariables = Box.createVerticalBox();
        hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));

        Box hboxVariableX = Box.createHorizontalBox();
        Box hboxVariableY = Box.createHorizontalBox();
        Box hboxVariableZ = Box.createHorizontalBox();

        hboxVariables.add(Box.createHorizontalGlue());

        hboxVariables.add(hboxVariableX);
        hboxVariableX.add(labelForX);
        hboxVariableX.add(Box.createHorizontalStrut(10));
        hboxVariableX.add(textFieldX);

        hboxVariables.add(hboxVariableY);
        hboxVariableY.add(labelForY);
        hboxVariableY.add(Box.createHorizontalStrut(10));
        hboxVariableY.add(textFieldY);

        hboxVariables.add(hboxVariableZ);
        hboxVariableZ.add(labelForZ);
        hboxVariableZ.add(Box.createHorizontalStrut(10));
        hboxVariableZ.add(textFieldZ);

        Box hboxFormulaImage = Box.createHorizontalBox();
        hboxFormulaImage.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        hboxFormulaImage.add(Box.createHorizontalGlue());
        hboxFormulaImage.add(Box.createVerticalGlue());
        hboxFormulaImage.add(formulaImagePanel);
        hboxFormulaImage.add(Box.createHorizontalGlue());
        hboxFormulaImage.add(Box.createVerticalGlue());

        formulaImagePanel.setLayout(new BorderLayout());
        try {
            formulaImagePanel.setImage(ImageIO.read(new File("E:\\WORK\\WORKSPACES\\intellij\\lab1\\res\\frameLab\\formula1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        formulaImagePanel.setPreferredSize(new Dimension(10000, 10000));

        Box settingsBox = Box.createHorizontalBox();
        final Box hboxResult = Box.createHorizontalBox();
        Box memoryButtons = Box.createHorizontalBox();

        settingsBox.setBorder(BorderFactory.createLineBorder(Color.cyan));
        memoryButtons.setBorder(BorderFactory.createLineBorder(Color.cyan));
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        settingsBox.add(hboxResult);
        settingsBox.add(memoryButtons);


        // Создать область для вывода результата
        JLabel labelForResult = new JLabel("Результат: ");

        //labelResult = new JLabel("0");
        textFieldResult = new JTextField("0", 10);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        textFieldResult.setHorizontalAlignment(JTextField.LEADING);

        textFieldResult.setEditable(false);

        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(20));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());


        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    if (formulaId == 1)
                        result = calculate1(x, y, z);
                    else result = calculate2(x, y, z);
                    textFieldResult.setText(result.toString());
                    textFieldResult.setCaretPosition(0);


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("1");
                textFieldY.setText("1");
                textFieldZ.setText("1");
                mem1 = 0;
                textMem1.setText(mem1 + "");
                mem2 = 0;
                textMem2.setText(mem1 + "");
                mem3 = 0;
                textMem3.setText(mem1 + "");
                setTitle("Вычисление выражения по формуле");
                textFieldResult.setText("0");
            }
        });

        JButton buttonMP = new JButton("M+");
        buttonMP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paramId == 1) {
                    mem1 += Double.parseDouble(textFieldResult.getText());
                    textMem1.setText(mem1 + "");
                    textMem1.setCaretPosition(0);
                } else if (paramId == 2) {
                    mem2 += Double.parseDouble(textFieldResult.getText());
                    textMem2.setText(mem2 + "");
                    textMem2.setCaretPosition(0);
                } else if (paramId == 3) {
                    mem3 += Double.parseDouble(textFieldResult.getText());
                    textMem3.setText(mem3 + "");
                    textMem3.setCaretPosition(0);
                }
            }
        });

        JButton buttonMC = new JButton("MC");
        buttonMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paramId == 1) {
                    mem1 = 0;
                    textMem1.setText(mem1 + "");
                } else if (paramId == 2) {
                    mem2 = 0;
                    textMem2.setText(mem2 + "");
                } else if (paramId == 3) {
                    mem3 = 0;
                    textMem3.setText(mem3 + "");
                }
            }
        });


        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(BorderFactory.createLineBorder(Color.ORANGE));

        Box hboxMButtons = Box.createHorizontalBox();
        hboxMButtons.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        hboxMButtons.add(Box.createHorizontalGlue());
        hboxMButtons.add(buttonMP);
        hboxMButtons.add(Box.createHorizontalStrut(30));
        hboxMButtons.add(buttonMC);
        hboxMButtons.add(Box.createHorizontalGlue());

        settingsBox.add(hboxMButtons);

        Box vParamsBox = Box.createVerticalBox();
        Box hParams = Box.createHorizontalBox();
        Box hParamsText = Box.createHorizontalBox();

        vParamsBox.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        hParams.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        hRadioParams.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        hParamsText.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        vParamsBox.add(hParams);
        vParamsBox.add(hRadioParams);
        vParamsBox.add(hParamsText);

        hParamsText.add(Box.createHorizontalGlue());


        textMem1 = new JTextField("0", 10);
        textMem1.setMaximumSize(textMem1.getPreferredSize());
        textMem1.setHorizontalAlignment(JTextField.LEADING);
        textMem1.setEditable(false);
        hParamsText.add(textMem1);
        hParamsText.add(Box.createHorizontalStrut(15));

        textMem2 = new JTextField("0", 10);
        textMem2.setMaximumSize(textMem2.getPreferredSize());
        textMem2.setHorizontalAlignment(JTextField.LEADING);
        textMem2.setEditable(false);
        hParamsText.add(textMem2);
        hParamsText.add(Box.createHorizontalStrut(15));

        textMem3 = new JTextField("0", 10);
        textMem3.setMaximumSize(textMem3.getPreferredSize());
        textMem3.setHorizontalAlignment(JTextField.LEADING);
        textMem3.setEditable(false);
        hParamsText.add(textMem3);
        hParamsText.add(Box.createHorizontalGlue());

        hRadioParams.add(Box.createHorizontalGlue());
        addRadioParams("Параметр 1", 1);
        addRadioParams("Параметр 2", 2);
        addRadioParams("Параметр 3", 3);
        radioParamsButtons.setSelected(radioParamsButtons.getElements().nextElement().getModel(), true);
        hRadioParams.add(Box.createHorizontalGlue());

        // Связать области воедино в компоновке BoxLayout
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxFormulaImage);
        contentBox.add(settingsBox);
        contentBox.add(hboxButtons);
        contentBox.add(vParamsBox);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }

    // Главный метод класса
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}