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
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;


    @Column(name = "brand", length = 50, nullable = false)
    private String brand;


    @Column(name = "model", length = 50, nullable = false)
    private String model;
    

    @Column(name = "manufactureyear", nullable = false)
    private int manufactureYear;


    @Column(name = "modelyear", nullable = false)
    private int modelYear;


    @Column(name = "value", nullable = false)
    private float value;


    @Column(name = "registerdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate registerDate;


    @Column(name = "description", length = 1000, nullable = false)
    private String description;


    @Column(name = "image", length = 1000, nullable = false)
    private String image;


    @Column(name = "interest", nullable = false)
    private Boolean interest = false;





    public int getID() {
        return this.ID;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufactureYear() {
        return this.manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getModelYear() {
        return this.modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public LocalDate getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getInterest() {
        return this.interest;
    }

    public void setInterest() {
        this.interest = !this.interest;
    }

    
}