package com.company.MainFrame;


import com.company.DataBase.DataBaseCharacters;
import com.company.MainFrame.Main_Frame;
import com.company.Users;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PersonalCharacters extends JPanel {

    JPanel panel;

    JLabel label_firstText;
    JLabel label_age_lich;
    JLabel label_weight_lich;
    JLabel label_height_lich;
    JLabel label_biceps;
    JLabel label_nogi;
    JLabel label_taliya;
    JLabel labelBackground;

    JTextField text_age_lich;
    JTextField text_weight_lich;
    JTextField text_height_lich;
    JTextField text_biceps;
    JTextField text_nogi;
    JTextField text_taliya;

    JButton button_save;

    //Создаем строки, которые будут запоминать и снова выводить введенные данные:

    String a;
    String b;
    String c;



    public void PersonalCharakters(){

        Main_Frame main_frame = new Main_Frame();
        GetUsers getUsers = new GetUsers();

        setLayout(null);

        labelBackground = new JLabel(new ImageIcon("images/heartbeat3.png"));
        labelBackground.setBounds(0, 0, 900, 800);

        JLabel labelPng = new JLabel(new ImageIcon("images/back2.png"));
        labelPng.setBounds(40, 15, 65, 50);
        labelPng.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MainFrameAction mainFrameAction = new MainFrameAction();
                setVisible(false);
                mainFrameAction.mainFrameAction();
            }
        });

        label_firstText= new JLabel("Перед продолжением заполните все поля!");
        label_firstText.setBounds(280, 70, 300, 20);

        label_age_lich = new JLabel("Возраст"); //Переименовала "label_age" и т.д. на "label_age_lich" и т.д., ибо в Мейн_Фрейме такие же переменные: запутаешься
        label_age_lich.setBounds(60, 165, 300, 20);

        text_age_lich = new JTextField(20);
        text_age_lich.setBounds(60, 185, 200, 20);
        text_age_lich.setText(a); //Закрепляем за полем уже введенное и сохраненное значение

        label_weight_lich = new JLabel("Вес: ");
        label_weight_lich.setBounds(60, 215, 300, 20);

        text_weight_lich = new JTextField(20);
        text_weight_lich.setBounds(60, 235, 200, 20);
        text_weight_lich.setText(b); //Закрепляем за полем уже введенное и сохраненное значение

        label_height_lich = new JLabel("Рост: ");
        label_height_lich.setBounds(60, 265, 200, 20);

        text_height_lich = new JTextField(20);
        text_height_lich.setBounds(60, 285, 200, 20);
        text_height_lich.setText(c); //Закрепляем за полем уже введенное и сохраненное значение

        label_biceps = new JLabel("Бицепс:");
        label_biceps.setBounds(320, 165, 300, 20);

        text_biceps = new JTextField(20);
        text_biceps.setBounds(320, 185, 200, 20);

        label_nogi = new JLabel("Объем ног: ");
        label_nogi.setBounds(320, 215, 300, 20);

        text_nogi = new JTextField(20);
        text_nogi.setBounds(320, 235, 200, 20);

        label_taliya = new JLabel("Объем талии");
        label_taliya.setBounds(320, 265, 200, 20);

        text_taliya = new JTextField(20);
        text_taliya.setBounds(320, 285, 200, 20);
        button_save = new JButton("Сохранить");
        button_save.setBounds(90, 310, 150, 30);
        button_save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int age = Integer.parseInt(text_age_lich.getText());
                int weight = Integer.parseInt(text_weight_lich.getText());
                int hight = Integer.parseInt(text_height_lich.getText());
                int biceps = Integer.parseInt(text_biceps.getText());
                int legs = Integer.parseInt(text_nogi.getText());
                int taliya = Integer.parseInt(text_taliya.getText());


                getUsers.list.set(0, getUsers.list.get(0)).setAge(age);
                getUsers.list.set(0, getUsers.list.get(0)).setWeight(weight);
                getUsers.list.set(0, getUsers.list.get(0)).setHight(hight);
                getUsers.list.set(0, getUsers.list.get(0)).setBiceps(biceps);
                getUsers.list.set(0, getUsers.list.get(0)).setLegs(legs);
                getUsers.list.set(0, getUsers.list.get(0)).setTaliya(taliya);
//                users.setAge(age);
//                users.setWeight(weight);
//                users.setHight(hight);
//                users.setBiceps(biceps);
//                users.setLegs(legs);
//                users.setTaliya(taliya);

                DataBaseCharacters dataBaseCharacters = new DataBaseCharacters();
                try {
                    dataBaseCharacters.conCharacters();
                    dataBaseCharacters.createCharacters();
                    dataBaseCharacters.writeCharacters();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }

                text_age_lich.setText("");
                text_weight_lich.setText("");
                text_height_lich.setText("");
                text_biceps.setText("");
                text_nogi.setText("");
                text_taliya.setText("");


/*               //Присваиваем введенные в полях значения, таким образом сохраняя их:

                a = text_age_lich.getText();
                b = text_weight_lich.getText();
                c = text_height_lich.getText();

                System.out.println(a+" "+b+" "+c); //Проверка, что всё гуд

                //Вот дальше вообще не знаю, что делалось :D Но я не удаляла, мало ли:

                int zero = 0;
                int age_2;
                int weight_2;
                int height_2;

                age_2 = Integer.parseInt(text_age.getText());
                age_2 += zero;
                System.out.println(age);

                weight_2 = Integer.parseInt(text_weight.getText());
                weight_2 += zero;
                System.out.println(weight);

                height_2 = Integer.parseInt(text_height.getText());
                height_2 += zero;
                System.out.println(hight);

                age = age_2;
                weight = weight_2;
                hight = height_2;
*/
            }
        });

        add(labelBackground);
        add(labelPng);
        add(label_firstText);
        add(label_age_lich);
        add(text_age_lich);
        add(label_weight_lich);
        add(text_weight_lich);
        add(label_height_lich);
        add(text_height_lich);
        add(label_biceps);
        add(text_biceps);
        add(label_nogi);
        add(text_nogi);
        add(label_taliya);
        add(text_taliya);
        add(button_save);

    }
}
