package com.company;

public class Users {

        static String name;
        int age = 0;
        int weight = 0;
        int hight = 0;
        double percent_of_fatInOrganism;
        String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public double getPercent_of_fatInOrganism() {
        return percent_of_fatInOrganism;
    }

    public void setPercent_of_fatInOrganism(double percent_of_fatInOrganism) {
        this.percent_of_fatInOrganism = percent_of_fatInOrganism;
    }

    public Users(String name, int age, int weight, int hight, double percent_of_fatInOrganism) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.hight = hight;
        this.percent_of_fatInOrganism = percent_of_fatInOrganism;
    }

    public Users(String name) {
        this.name = name;
    }

    public Users() {
    }

    public Users(String name, String password){
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (age != users.age) return false;
        return password != null ? password.equals(users.password) : users.password == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "name = " + name + "\n" + "password = " + password + "\n";
    }
}
