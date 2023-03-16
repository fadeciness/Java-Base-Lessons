package com.github.fadeciness.lesson9.homework.entity;

import com.github.fadeciness.lesson9.homework.annotation.Column;
import com.github.fadeciness.lesson9.homework.annotation.Table;

@Table(title = "dog")
public class Dog {
    @Column
    private long id;
    @Column(name = "nickname")
    private String nick;

    @Column
    private int age;

    @Column(name = "voice")
    private String bark;

    public Dog(long id, String name, int age, String bark) {
        this.id = id;
        this.nick = name;
        this.age = age;
        this.bark = bark;
    }

    public Dog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }
}
