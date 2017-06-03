package com.company.DataBase;


import com.company.Autorization.Autorization;
import com.company.Autorization.Registration;
import com.company.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBasePasswords {

    public static Connection con;
    public static Statement stat;
    public static ResultSet resSet;

    static String loginCheck;
    static String passwordCheck;

    static String loginWrite;
    static String passwordWrite;

    public static List<Users> list = new ArrayList<>();

    public static void conPassword() throws SQLException, ClassNotFoundException {
        con = null;
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:Main.s3db");

        System.out.println("Data base is active");
    }

    public static void createPassword() throws SQLException {

        stat = con.createStatement();
        stat.execute("CREATE TABLE if not exists 'passwords' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'login' text, 'passwords' text)");

        System.out.println("The tabl was created!");
    }

    public static void writePasswords() throws SQLException{

        Registration registration = new Registration();

        loginWrite = registration.login;
        passwordWrite = registration.password;

        PreparedStatement ps = con.prepareStatement("insert into 'passwords' values (?, ?, ?)");

        ps.setString(2, loginWrite);
        ps.setString(3, passwordWrite);

        ps.executeUpdate();

//        stat.execute("INSERT INTO 'passwords' ('login', 'passwords') VALUES ('MainStar', '12qwaszx')");

        System.out.println("Данные нового пользователя в базу данных внесенны!");
    }

    public List<Users> readPasswords() throws SQLException {

        Autorization autorization = new Autorization();

        loginCheck = autorization.name;
        passwordCheck = autorization.password;

        resSet = stat.executeQuery("SELECT * FROM passwords");

        String password = null;
        String name = null;

        while (resSet.next()) {

            int id = resSet.getInt("id");
            name = resSet.getString("login");
            password = resSet.getString("passwords");

            System.out.println("Id" + id);
            System.out.println("Name" + name);
            System.out.println("Password" + password);

            Users users = new Users();
            users.setName(name);
            users.setPassword(password);
            list.add(users);

        }
        return list;
    }

    public static void closePassword() throws SQLException{
        resSet.close();
        stat.close();
        con.close();
    }
}
