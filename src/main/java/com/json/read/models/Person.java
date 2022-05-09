package com.json.read.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    private String firstName;
    private String lastName;
    private String age;
    private String phone;
    private Address address;
}
