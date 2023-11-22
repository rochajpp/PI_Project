package com.pi_engenhariadesoftware.pi_project.entities;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;


    @Column(name = "login", length = 10, nullable = false)
    private String login;


    @Column(name = "password", length = 20, nullable = false)
    private String password;


    @Column(name = "name", length = 100, nullable = false)
    private String name;


    @Column(name = "active", nullable = false)
    private Boolean active;


    @Column(name = "birthdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;


    @Column(name = "registerdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate registerDate;




    public int getId(){
        return this.ID;
    }

    public String getLogin(){
        return this.login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Boolean getActive(){
        return this.active;
    }

    public void setActive(Boolean active){
        this.active = active;
    }

    public LocalDate getBirthDate(){
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public LocalDate getRegisterDate(){
        return this.registerDate;
    }

    public void setRegisterDate(LocalDate registerDate){
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "User [ID=" + ID + ", login=" + login + ", password=" + password + ", name=" + name + ", active="
                + active + ", birthDate=" + birthDate + ", registerDate=" + registerDate + "]";
    }






}
