package org.example.model;

import lombok.Data;

@Data
public class Personne {
    private String name;
    private String email;
    private String gender;

    @Override
    public String toString() {
        return "Nom :" + name +
                " Email :" + email +
                " Genre :" + gender ;
    }
}
