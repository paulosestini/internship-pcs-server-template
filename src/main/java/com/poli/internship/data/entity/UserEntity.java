package com.poli.internship.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    private LocalDate birthdate;

    protected UserEntity() {}

    public UserEntity(String name, String password, LocalDate birthdate) {
        this.name = name;
        this.password = password;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
}
