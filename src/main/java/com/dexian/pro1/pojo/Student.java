package com.dexian.pro1.pojo;

public class Student {
    private String code;

    private String name;

    private Integer sex;

    private Integer age;

    private String sclass;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass == null ? null : sclass.trim();
    }

    public Student() {
    }

    public Student(String code, String name, Integer sex, Integer age, String sclass) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sclass = sclass;
    }
}