package com.company.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pitanie extends JFrame {

    JPanel panel_pit = new JPanel();
    JLabel label_pit = new JLabel("Выберите желаемый режим диеты, чтобы продолжить:");
    JButton button_pit_leg = new JButton("Легкая");
    JButton button_pit_tiazh = new JButton("Жесткая");
    JTextArea area_pit = new JTextArea(23,30);
    String s_pit = "ПИТ!";

   public void pitanie() {

        setTitle(s_pit);
        setSize(400,500);
        setVisible(true);
        setLocationRelativeTo(null);

        area_pit.setEditable(false);

        panel_pit.add(label_pit);
        panel_pit.add(button_pit_leg);
        panel_pit.add(button_pit_tiazh);
        panel_pit.add(area_pit);
        add(panel_pit);

        area_pit.setLineWrap(true);
        area_pit.setWrapStyleWord(true);
        area_pit.setForeground(Color.blue);

        button_pit_leg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_pit.setText("Легкая диета предусматривает такое питание:\n\n1. Утро. Овсянка, 2 вареных яйца и чай.\n2. День. Любая каша, салат, пареная рыба или курица, чай.\n3. Вечер. Кефир, творог.");
            }
        });

        button_pit_tiazh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_pit.setText("Жесткая диета предусматривает такое питание:\n\n1. Утро. Овсянка, 2 вареных яйца, вода.\n2. День. Гречневая или рисовая каша, пареная рыба, вода.\n3. Вечер. Кефир, творог, половинка авокадо.");
            }
        });
    }
}
