package com.example.kafkaproducderwithkstream;

import lombok.Getter;
import lombok.Setter;

/**
 * created by lovedeep in com.example.kafkaproducderwithkstream
 */
@Getter
@Setter
public class User {
    String id;
    String name;
    String company;

    public User(String name, String company) {
        this.name = name;
        this.company = company;
    }
}