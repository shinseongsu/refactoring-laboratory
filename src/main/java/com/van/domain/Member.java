package com.van.domain;

import lombok.*;

@Getter
public class Member {

    private Long id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
