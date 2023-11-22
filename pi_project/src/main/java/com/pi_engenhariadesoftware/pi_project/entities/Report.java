package com.pi_engenhariadesoftware.pi_project.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;



@Entity
public class Report {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idcar", nullable = false)
    private Long car;

    @Column(name = "nameclient", length = 100, nullable = false)
    private String nameClient;

    @Column(name = "phoneclient", length = 20, nullable = false)
    private String phoneClient;

    @Column(name  = "registerdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate registerDate;

    public Report(){
        
    }

    public Report(Long car, String nameClient, String phoneClient){
        this.car = car;
        this.nameClient = nameClient;
        this.phoneClient = phoneClient;
        this.registerDate = LocalDate.now();
    }

    public int getId(){
        return this.id;
    }

    public Long getIdCar(){
        return this.car;
    }

    public String getNameClient(){
        return this.nameClient;
    }
    public void setNameClient(String nameClient){
        this.nameClient = nameClient;
    }

    public String getPhoneClient(){
        return this.phoneClient;
    }
    public void setPhoneClient(String phoneClient){
        this.phoneClient = phoneClient;
    }

    public LocalDate getRegisterDate(){
        return this.registerDate;
    }
    public void setRegisterDate(LocalDate registerDate){
        this.registerDate = registerDate;
    }

}
