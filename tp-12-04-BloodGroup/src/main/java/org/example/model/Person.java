package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    int id;
    String name;
    Gender gender;
    int age;
    String BloodGroup;
    String contactNo;
    Qualification qualification;
    Date startDate;
    String address;
    String image;
}
