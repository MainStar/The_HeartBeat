package com.company.MainFrame;

import com.company.DataBase.DataBasePasswords;
import com.company.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrameAction extends JPanel {

    JPanel panel_2;
    JLabel label;
    JLabel labelbackground;

    String name;

    Users users = new Users();
    PersonalCharacters personalCharacters = new PersonalCharacters();
    DataBasePasswords dataBasePasswords = new DataBasePasswords();
    List<Users> list = new ArrayList<>();
    Main_Frame main_frame = new Main_Frame();

    public void mainFrameAction(){

        panel_2 = new JPanel();
        panel_2.setLayout(null);

//        try {
//            dataBasePasswords.readPasswords();
//            list = dataBasePasswords.list; //Получили лист с базы данных, и теперь его можно использоватья в коде
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        name = users.getName();

        labelbackground = new JLabel(new ImageIcon("images/heartbeat2.png"));
        labelbackground.setBounds(0, 0, 900, 800);


        JLabel label_nameSecond = new JLabel();
        label_nameSecond.setBounds(700, 30, 250, 25);

//        if (name.equals("")){
//            name.toString();
//            label_nameSecond.setText("Ваше имя: Panteleon");
//        }
//        else {
//            label_nameSecond.setText("Ваше имя: " + name);
//        }

        JLabel label_first_secondFrame = new JLabel("Для удовлетворенной работы с прораммой заполните личные данные!");
        label_first_secondFrame.setBounds(105, 150, 500, 20);

        JButton button_Mybode = new JButton("Личные данные");
        button_Mybode.setBounds(100, 180, 200, 120);

        button_Mybode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panel_2.setVisible(false);
                main_frame.frame.add(personalCharacters);
                personalCharacters.PersonalCharakters();

            }
        });

        JButton button_training = new JButton("Тренировки");
        button_training.setBounds(350, 180, 200, 120);

        JButton buttn_HealthFood = new JButton("Здоровое питание");
        buttn_HealthFood.setBounds(100, 320, 200, 120);

        JButton button_4 = new JButton("Записи улучшений");
        button_4.setBounds(350, 320, 200, 120);

        button_training.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Trenirovki trenirovki = new Trenirovki();
                trenirovki.trenirovki();
            }
        });

        buttn_HealthFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Pitanie pitanie = new Pitanie();
                pitanie.pitanie();
            }
        });

        label = new JLabel("All rights are reserved by MainStar corporation©");
        label.setBounds(300, 700, 300, 50);

        main_frame.frame.add(panel_2);
        panel_2.add(labelbackground);
        panel_2.add(label_nameSecond);
        panel_2.add(label_first_secondFrame);
        panel_2.add(button_Mybode);
        panel_2.add(button_training);
        panel_2.add(buttn_HealthFood);
        panel_2.add(button_4);
        panel_2.add(label);
    }
}
