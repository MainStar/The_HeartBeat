package com.company.MainFrame;


import com.company.Users;

import java.util.*;

public class GetUsers {
    Users users = new Users();
    public static List<Users> list = new ArrayList<>();

    public List<Users> getUser(){
        list.add(users);
        return list;
    }
}
