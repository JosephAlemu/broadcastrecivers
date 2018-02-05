package com.example.user.broadcastreceivers.model;

import java.io.Serializable;

/**
 * Created by Admin on 2/4/2018.
 */

public class Person implements Serializable {

    public int id;
    private String name;
    private String title;
    private int image;
    private int age;
    private String gender;

    public Person(int id, String name, String title, int image, int age, String gender) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.image = image;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

}
