package com.github.fadeciness.lesson9.homework.entity;

import com.github.fadeciness.lesson9.homework.annotation.Column;
import com.github.fadeciness.lesson9.homework.annotation.Table;

@Table(title = "cat")
public class Cat {
    @Column
    private long id;
    @Column(name = "nickname")
    private String nick;

    @Column
    private int age;

    public Cat(long id, String name, int age) {
        this.id = id;
        this.nick = name;
        this.age = age;
    }

    public Cat() {
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
}
