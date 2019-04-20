package com.itcast.web.model;

import java.util.Arrays;
import java.util.Date;

public class User {
    private Integer id;

    private String username;
    private String password;
    private  int age;
    private String gender;
    private Date birthday;
    private  String[] hobbyIds;

    public User(String username, int age, String gender, Date birthday) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", hobbyIds=" + Arrays.toString(hobbyIds) +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String[] getHobbyIds() {
        return hobbyIds;
    }

    public void setHobbyIds(String[] hobbyIds) {
        this.hobbyIds = hobbyIds;
    }
}
