package com.company.DataBase;


import com.company.Autorization.Registration;
import com.company.MainFrame.GetUsers;
import com.company.MainFrame.PersonalCharacters;
import com.company.Users;

import java.sql.*;

public class DataBaseCharacters {
    public static Connection con;
    public static Statement stat;
    public static ResultSet resSet;

    public static void conCharacters() throws SQLException, ClassNotFoundException {
        con = null;
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:Main.s3db");

        System.out.println("Data base is active 1");
    }

    public static void createCharacters() throws SQLException {

        stat = con.createStatement();
        stat.execute("CREATE TABLE if not exists 'personalCharacters' ('name' text, 'age' INTEGER, 'weight' INTEGER, 'growth' INTEGER, 'biceps' INTEGER, 'legs' INTEGER, 'waist', INTEGER)");

        System.out.println("The tabl was created! 1");
    }

    public static void writeCharacters() throws SQLException{

        GetUsers getUsers = new GetUsers();

        String name = getUsers.list.get(0).getName();
        int age = getUsers.list.get(0).getAge();
        int weight = getUsers.list.get(0).getWeight();
        int hight = getUsers.list.get(0).getHight();
        int biceps = getUsers.list.get(0).getBiceps();
        int legs = getUsers.list.get(0).getLegs();
        int taliya = getUsers.list.get(0).getTaliya();



        PreparedStatement ps = con.prepareStatement("insert into 'personalCharacters' values (?, ?, ?, ?, ?, ?, ?)");

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, weight);
        ps.setInt(4, hight);
        ps.setInt(5, biceps);
        ps.setInt(6, legs);
        ps.setInt(7, taliya);

        ps.executeUpdate();

//        stat.execute("INSERT INTO 'passwords' ('login', 'passwords') VALUES ('MainStar', '12qwaszx')");

        System.out.println("Данные нового пользователя в базу данных внесенны! 1");
    }


}
