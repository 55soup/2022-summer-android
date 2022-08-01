package com.cookandroid.and0801_04_activityput2;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String gender;
    private String tel;
    private String add;

    public Person(String name, String gender, String tel, String add) { //생성자
        this.name = name;
        this.gender = gender;
        this.tel = tel;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

}

