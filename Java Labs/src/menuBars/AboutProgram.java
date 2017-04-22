package menuBars;

import frameLab.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AboutProgram extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel imageLabel;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;

    public AboutProgram() throws Exception {
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);
        setContentPane(contentPane);
        setModal(true);
        setTitle("О приложении");
        getRootPane().setDefaultButton(buttonOK);
        setSize(WIDTH, HEIGHT);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        dispose();
    }

    public static void main(String[] args) throws Exception {
        AboutProgram dialog = new AboutProgram();

        dialog.pack();
        dialog.setVisible(true);

        System.exit(0);
    }
}
