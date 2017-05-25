package com.company.Autorization;

import com.company.MainFrame.Main_Frame;
import com.company.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Registration extends JPanel {

    String name;

    JPanel panel;
    JPanel panel_2;
    JPanel panel_3;
    JLabel label_1;
    JLabel label_name;
    JLabel label_pasword;
    JLabel label_parol_sostoit;
    JLabel label_pasword_2;
    JLabel label_error = new JLabel();
    JTextField textName;
    JTextField textPasword_1;
    JTextField text_pasword_2;
    JButton button;

    Users users = new Users();
    Users sc;

    public static String login;
    public static String password;

    public void registration(){
        Autorization autorization = new Autorization();

        autorization.panel.setVisible(false);
        autorization.panel_2.setVisible(false);
        autorization.panel_3.setVisible(false);

        BorderLayout br = new BorderLayout();
        setLayout(br);

        panel = new JPanel();
        panel_2 = new JPanel();

        label_1 = new JLabel("Заполните поля ниже для регистрации: ");
        label_name = new JLabel("Логин: ");
        textName = new JTextField(25);
        login = textName.getText();

        name = textName.getName();
        sc = new Users(name);

        label_pasword = new JLabel("Пароль: ");
        textPasword_1 = new JTextField(25);
        label_pasword_2 = new JLabel("Подтвердите пароль: ");
        text_pasword_2 = new JTextField(25);
        label_parol_sostoit = new JLabel("Пароль должен состоять от 6 до 20 сиволов! ");
        button = new JButton("Продолжить");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String pasword1 = textPasword_1.getText();
                String pasword2 = text_pasword_2.getText();

                System.out.println(users.getName());

                if (textPasword_1.getText().equals("")) {
                    label_error.setText("Что то пошло не так. Необходимо заполнить поля паролей!");
                }else {
                    if (pasword2.equals(pasword1)) {

                        password = text_pasword_2.getText();

                        //dispose();
                        Main_Frame main_frame = new Main_Frame();
                        main_frame.Button_Action();
                    }else {

                        textPasword_1.setText("");
                        text_pasword_2.setText("");

                        label_error.setText("Что то пошло не так. Не верное подтверждение пароля!");
                    }
                }
            }
        });

        add(panel, BorderLayout.NORTH);
        add(panel_2, BorderLayout.CENTER);

        panel.add(label_1);
        panel_2.add(label_name);
        panel_2.add(textName);

        panel_2.add(label_pasword);
        panel_2.add(textPasword_1);
        panel_2.add(label_pasword_2);
        panel_2.add(text_pasword_2);
        panel_2.add(label_parol_sostoit);
        panel_2.add(button);
        panel_2.add(label_error);
    }
}
