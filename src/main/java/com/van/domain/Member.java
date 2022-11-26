package com.van.domain;

import lombok.*;

@Getter
public class Member {

    private Long id;
    private String name;
    private int age;

    public Member() { }

    public Member(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
