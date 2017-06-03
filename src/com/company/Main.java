package com.company;

import com.company.Autorization.Autorization;
import com.company.DataBase.DataBasePasswords;
import com.company.MainFrame.Main_Frame;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        Main_Frame main_frame = new Main_Frame();
//        main_frame.Button_Action();
        DataBasePasswords dataBasePasswords = new DataBasePasswords();
        dataBasePasswords.conPassword();
        dataBasePasswords.createPassword();
        //dataBasePasswords.writePasswords();

        Autorization autorization = new Autorization();
        autorization.login_frame();
    }
}
