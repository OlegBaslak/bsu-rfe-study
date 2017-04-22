package drawLab;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by Олег on 01.11.2014.
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    private final static int WIDTH = 800;
    private final static int HEIGHT = 600;

    private JFileChooser fileChooser = null;
    private JFileChooser fileChooser1 = null;
    private JCheckBoxMenuItem showAxisMenuItem;
    private JCheckBoxMenuItem showAxisMenuItem1;
    private JCheckBoxMenuItem showMarkersMenuItem;
    private JCheckBoxMenuItem showMarkersMenuItem1;
    private JCheckBoxMenuItem rotate90MenuItem;
    private JCheckBoxMenuItem rotate90MenuItem1;

    private GraphicsDisplay display = new GraphicsDisplay();

    private boolean fileLoaded = false;
    private boolean fileLoaded1 = false;


    public MainFrame() {
        super("Построение графиков функций на основе подготовленных файлов");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);
        setExtendedState(MAXIMIZED_BOTH);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
        Action openGraphicsAction = new AbstractAction("Открыть файл") {
            public void actionPerformed(ActionEvent event) {
                if (fileChooser == null) {
                    fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("."));
                }
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                    try {
                        openGraphics(fileChooser.getSelectedFile());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        };
        fileMenu.add(openGraphicsAction);

        Action openBinGraphicsAction = new AbstractAction("Открыть бинарный файл") {
            public void actionPerformed(ActionEvent event) {

                if (fileChooser == null) {
                    fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("."));
                }
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                    try {
                        openBinGraphics(fileChooser.getSelectedFile());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        };
        fileMenu.add(openBinGraphicsAction);

        JMenu fileMenu1 = new JMenu("Файл 2");
        menuBar.add(fileMenu1);
        Action openGraphicsAction1 = new AbstractAction("Открыть файл") {
            public void actionPerformed(ActionEvent event) {
                if (fileChooser1 == null) {
                    fileChooser1 = new JFileChooser();
                    fileChooser1.setCurrentDirectory(new File("."));
                }
                if (fileChooser1.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                    try {
                        openGraphics1(fileChooser1.getSelectedFile());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        };
        fileMenu1.add(openGraphicsAction1);

        Action openBinGraphicsAction1 = new AbstractAction("Открыть бинарный файл") {
            public void actionPerformed(ActionEvent event) {

                if (fileChooser1 == null) {
                    fileChooser1 = new JFileChooser();
                    fileChooser1.setCurrentDirectory(new File("."));
                }
                if (fileChooser1.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                    try {
                        openBinGraphics1(fileChooser1.getSelectedFile());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        };
        fileMenu1.add(openBinGraphicsAction1);

        JMenu graphicsMenu = new JMenu("График");
        menuBar.add(graphicsMenu);
        Action showAxisAction = new AbstractAction("Показывать оси координат") {
            public void actionPerformed(ActionEvent event) {
                display.setShowAxis(showAxisMenuItem.isSelected());
            }
        };

        showAxisMenuItem = new JCheckBoxMenuItem(showAxisAction);
        graphicsMenu.add(showAxisMenuItem);
        showAxisMenuItem.setSelected(true);

        Action rotate90Action = new AbstractAction("Поворот") {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!display.isRotate90()) {
                    display.setRotate90(true);
                    display.rotate();
                } else {
                    display.setRotate90(false);
                    display.rotateBack();
                }
            }
        };

        rotate90MenuItem = new JCheckBoxMenuItem("Поворот");
        rotate90MenuItem.setState(false);
        rotate90MenuItem.setAction(rotate90Action);
        graphicsMenu.add(rotate90MenuItem);
        rotate90MenuItem.setEnabled(false);


        Action showMarkersAction = new AbstractAction("Показывать маркеры точек") {
            public void actionPerformed(ActionEvent event) {
                display.setShowMarkers(showMarkersMenuItem.isSelected());
            }
        };

        showMarkersMenuItem = new JCheckBoxMenuItem(showMarkersAction);
        graphicsMenu.add(showMarkersMenuItem);
        graphicsMenu.addMenuListener(new GraphicsMenuListener());
        showMarkersMenuItem.setSelected(false);
        showMarkersMenuItem.setState(true);
        getContentPane().add(display, BorderLayout.CENTER);


        JMenu graphicsMenu1 = new JMenu("График 2");
        menuBar.add(graphicsMenu1);
        Action showAxisAction1 = new AbstractAction("Показывать оси координат") {
            public void actionPerformed(ActionEvent event) {
                display.setShowAxis1(showAxisMenuItem1.isSelected());
            }
        };

        showAxisMenuItem1 = new JCheckBoxMenuItem(showAxisAction1);
        graphicsMenu1.add(showAxisMenuItem1);
        showAxisMenuItem1.setSelected(true);

        Action rotate90Action1 = new AbstractAction("Поворот") {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!display.isRotate901()) {
                    display.setRotate901(true);
                    display.rotate1();
                } else {
                    display.setRotate901(false);
                    display.rotateBack1();
                }
            }
        };

        rotate90MenuItem1 = new JCheckBoxMenuItem("Поворот");
        rotate90MenuItem1.setState(false);
        rotate90MenuItem1.setAction(rotate90Action1);
        graphicsMenu1.add(rotate90MenuItem1);
        rotate90MenuItem1.setEnabled(false);


        Action showMarkersAction1 = new AbstractAction("Показывать маркеры точек") {
            public void actionPerformed(ActionEvent event) {
                display.setShowMarkers1(showMarkersMenuItem1.isSelected());
            }
        };

        showMarkersMenuItem1 = new JCheckBoxMenuItem(showMarkersAction1);
        graphicsMenu1.add(showMarkersMenuItem1);
        graphicsMenu1.addMenuListener(new GraphicsMenuListener());
        showMarkersMenuItem1.setSelected(false);
        showMarkersMenuItem1.setState(true);


        getContentPane().add(display, BorderLayout.CENTER);


    }

    public static Double[][] create_list(File selectedFile) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(selectedFile));
        ArrayList<Double> tempList = new ArrayList<Double>();
        String x = r.readLine();
        while ((x = r.readLine()) != null) {
            String[] temp = x.split(" ");
            tempList.add(Double.parseDouble(temp[0]));
            tempList.add(Double.parseDouble(temp[1]));
        }
        Double[][] list = new Double[tempList.size() / 2][];
        for (int i = 0, j = 0; i < tempList.size() && j < list.length; list[j++] = new Double[]{tempList.get(i++), tempList.get(i++)})
            ;

        return list;
    }

    protected void openGraphics(File selectedFile) throws Exception {
        try {
            Double[][] graphicsData = null;
            graphicsData = create_list(selectedFile);
            for (Double[] x : graphicsData) System.out.println(x[0] + "   " + x[1]);
            if (graphicsData != null && graphicsData.length > 0) {
                fileLoaded = true;
                display.showGraphics(graphicsData);
            }
            display.setRotate90(false);
            rotate90MenuItem.setState(false);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, "Указанный файл не найден", "Ошибка загрузки данных", JOptionPane.WARNING_MESSAGE);
            return;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, "Ошибка чтения координат точек из файла", "Ошибка загрузки данных", JOptionPane.WARNING_MESSAGE);
            return;
        }

    }

    protected void openGraphics1(File selectedFile) throws Exception {
        try {
            Double[][] graphicsData1 = null;
            graphicsData1 = create_list(selectedFile);
            for (Double[] x : graphicsData1) System.out.println(x[0] + "   " + x[1]);
            if (graphicsData1 != null && graphicsData1.length > 0) {
                fileLoaded1 = true;
                display.showGraphics1(graphicsData1);
            }
            display.setRotate901(false);
            rotate90MenuItem1.setState(false);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, "Указанный файл не найден", "Ошибка загрузки данных", JOptionPane.WARNING_MESSAGE);
            return;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, "Ошибка чтения координат точек из файла", "Ошибка загрузки данных", JOptionPane.WARNING_MESSAGE);
            return;
        }

    }

    protected void openBinGraphics(File selectedFile) throws Exception {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(selectedFile));
            Double[][] graphicsData = new Double[in.available() / (Double.SIZE / 8) / 2][];
            int i = 0;
            while (in.available() > 0) {
                Double x = in.readDouble();
                Double y = in.readDouble();
                graphicsData[i++] = new Double[]{x, y};
                System.out.println(graphicsData[i - 1][0]);
                System.out.println(graphicsData[i - 1][1]);
            }
            display.setRotate90(false);
            rotate90MenuItem.setState(false);
            if (graphicsData != null && graphicsData.length > 0) {
                fileLoaded = true;
                display.showGraphics(graphicsData);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, "Указанный файл не найден", "Ошибка загрузки данных", JOptionPane.WARNING_MESSAGE);
            return;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, "Ошибка чтения координат точек из файла", "Ошибка загрузки данных", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }

    protected void openBinGraphics1(File selectedFile) throws Exception {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(selectedFile));
            Double[][] graphicsData1 = new Double[in.available() / (Double.SIZE / 8) / 2][];
            int i = 0;
            while (in.available() > 0) {
                Double x = in.readDouble();
                Double y = in.readDouble();
                graphicsData1[i++] = new Double[]{x, y};
                System.out.println(graphicsData1[i - 1][0]);
                System.out.println(graphicsData1[i - 1][1]);
            }
            display.setRotate901(false);
            rotate90MenuItem1.setState(false);
            if (graphicsData1 != null && graphicsData1.length > 0) {
                fileLoaded1 = true;
                display.showGraphics1(graphicsData1);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, "Указанный файл не найден", "Ошибка загрузки данных", JOptionPane.WARNING_MESSAGE);
            return;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, "Ошибка чтения координат точек из файла", "Ошибка загрузки данных", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }


    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    private class GraphicsMenuListener implements MenuListener {

        public void menuSelected(MenuEvent e) {
            showAxisMenuItem.setEnabled(fileLoaded);
            showMarkersMenuItem.setEnabled(fileLoaded);
            rotate90MenuItem.setEnabled(fileLoaded);
            showAxisMenuItem1.setEnabled(fileLoaded1);
            showMarkersMenuItem1.setEnabled(fileLoaded1);
            rotate90MenuItem1.setEnabled(fileLoaded1);
        }

        public void menuDeselected(MenuEvent e) {

        }

        public void menuCanceled(MenuEvent e) {

        }
    }
}
