package com.example.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private Long id;
    private String name;
    private int age;
    private String email;
    private String address;
}
