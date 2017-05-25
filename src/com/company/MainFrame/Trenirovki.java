package com.company.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trenirovki extends JFrame{

    JPanel panel_treni = new JPanel();
    JLabel label_treni_rukowodstwo = new JLabel("Выберите желаемый режим тренировок, чтобы продолжить:");
    JButton button_treni_shadiash = new JButton("Щадящие");
    JButton button_treni_srednije = new JButton("Средние");
    JButton button_treni_usilennyje = new JButton("Хардовые");
    JTextArea area_treni = new JTextArea(23,30);
    String s_treni = "ТРЕНИ!";


   public void trenirovki(){

        setTitle(s_treni);
        setSize(400,500);
        setVisible(true);
        setLocationRelativeTo(null);

        area_treni.setEditable(false);

        panel_treni.add(label_treni_rukowodstwo);
        panel_treni.add(button_treni_shadiash);
        panel_treni.add(button_treni_srednije);
        panel_treni.add(button_treni_usilennyje);
        panel_treni.add(area_treni);
        add(panel_treni);

        area_treni.setLineWrap(true);
        area_treni.setWrapStyleWord(true);
        area_treni.setForeground(Color.blue);

        button_treni_shadiash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_treni.setText("Легкий режим предусматривает такие тренировочные нагрузки:\n\n1. Утро. Зарядка с использованием махов руками, прыжки.\n2. День. Выделите 10 минут на повороты корпуса вправо и влево.\n3. Вечер. Йога.");
                }
        });

        button_treni_srednije.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_treni.setText("Средний режим предусматривает такие тренировочные нагрузки:\n\n1. Утро. Зарядка, пробежка, прыжки.\n2. День. Выделите 10 минут на повороты корпуса вправо и влево, 2 минуты на приседания.\n3. Вечер. Йога.");
            }
        });

       button_treni_usilennyje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_treni.setText("Средний режим предусматривает такие тренировочные нагрузки:\n\n1. Утро. Зарядка, пробежка, прыжки, отжимания\n2. День. Выделите 10 минут на повороты корпуса вправо и влево, 2 минуты на приседания, 1 минуту на махи руками.\n3. Вечер. Зарядка для позвоночника, йога.");
            }
        });
    }

}
