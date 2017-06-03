package com.company.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Frame {

    //Убираем фрейм и экстандим класс. Меняем свойства фрейма и способ добавления элементов.
    static JFrame frame = new JFrame("The Heart Beat");


    public void Button_Action(){


        frame.setTitle("The HeartBeat");
        frame.setSize(900, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu file = new JMenu("File");
        menuBar.add(file);

        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int chois = JOptionPane.showConfirmDialog(null, "Уверенны что хотите выйти?", "Exit", JOptionPane.CANCEL_OPTION, JOptionPane.YES_NO_OPTION);
                if (chois == JOptionPane.YES_OPTION){
                    frame.dispose();
                }
                if (chois == JOptionPane.NO_OPTION){
                }
            }
        });
        JMenu about = new JMenu("About");
        menuBar.add(about);
        JMenuItem version = new JMenuItem("Version");
        about.add(version);
        version.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Version of program: 1.0.0", "Version", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JMenuItem Settings = new JMenuItem("Settings");
        file.add(Settings);
        Settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
/*
               Frame_Setting frame_setting = new Frame_Setting();
                frame_setting.frame_settings();
*/
            }
        });

        MainFrameAction mainFrameAction = new MainFrameAction();
        mainFrameAction.mainFrameAction();

    }
}
