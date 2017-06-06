package com.company.Autorization;

import com.company.DataBase.DataBasePasswords;
import com.company.MainFrame.GetUsers;
import com.company.MainFrame.Main_Frame;
import com.company.Users;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.List;


public class Autorization extends JFrame {

    Users users = new Users();

    static JPanel panel;
    static JPanel panel_2;
    static JPanel panel_3;
    JLabel label_1;
    JLabel label_name;
    JLabel label_pasword;
    JLabel label_Error = new JLabel();
    JTextField textName;
    JTextField textPasword_1;
    JTextField text_pasword_2;
    JButton button;
    JList list;

    String pass_2;

    String name_1;
    String pass;

    public static String name;
    public static String password;

    Main_Frame main_frame = new Main_Frame();

    public void login_frame(){

        DataBasePasswords dataBasePasswords = new DataBasePasswords();

        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BorderLayout br = new BorderLayout();
        setLayout(br);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu file = new JMenu("File");
        menuBar.add(file);

        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int chois = JOptionPane.showConfirmDialog(null, "Уверенны что хотите выйти?", "Exit", JOptionPane.CANCEL_OPTION, JOptionPane.YES_NO_OPTION);
                if (chois == JOptionPane.YES_OPTION){
                    dispose();
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

        panel = new JPanel();
        add(panel, BorderLayout.NORTH);

        panel_2 = new JPanel();
        add(panel_2, BorderLayout.CENTER);

        panel_3 = new JPanel();
        add(panel_3, BorderLayout.SOUTH);

        label_1 = new JLabel("Ведите логин и пароль для авторизации: ");
        label_name = new JLabel("Логин:     ");
        textName = new JTextField(25);
        label_pasword = new JLabel(" Пароль: ");
        textPasword_1 = new JTextField(25);
        button = new JButton("Продолжить");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                name = textName.getText();
                password = textPasword_1.getText().toString();

                textPasword_1.setText("");

                List<Users> list = new ArrayList<>();

                try {
                    list = dataBasePasswords.readPasswords();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                System.out.println(list);

                Iterator<Users> iterator = list.iterator();
                while (iterator.hasNext()){
                    Users el = iterator.next();
                    if (el.getName().equals(name)){
                        name_1 = el.getName();
                        pass = el.getPassword();

                        if (password.equals(pass) && name.equals(name_1)){

                            users.setName(textName.getText());
                            System.out.println(users.getName());

                            dispose();

                            try {
                                dataBasePasswords.closePassword();
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }

                            GetUsers getUsers = new GetUsers();
                            getUsers.getUser();
                            getUsers.list.set(0, getUsers.list.get(0)).setName(name_1);
                            getUsers.list.set(0, getUsers.list.get(0)).setPassword(password);
                            main_frame.Button_Action();

                        }
                        else {
                            label_Error.setText("Вы ввели не правильно логин либо пароль!");
                        }

                    }
                }
            }
        });

        String [] mass = {"Если вы еще Новичек нажмите здесь."};
        list = new JList(mass);

        JLabel background = new JLabel(new ImageIcon("images/line2.png"));

        panel.add(label_1);
        panel_2.add(label_name);
        panel_2.add(textName);
        panel_2.add(label_pasword);
        panel_2.add(textPasword_1);
        panel_2.add(button);
        panel_2.add(background);
        panel_2.add(label_Error);
        panel_3.add(list);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {



                Registration registration = new Registration();
                registration.registration();
                add(registration);
            }
        });
    }
}
