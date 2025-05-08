package ch.samt.carManager.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.util.Date;

//@Data
public class Car {

    @Id
    private Long id;


    @NotBlank
    private String color;


    @NotBlank
    @Column("CARMAKER")
    private String carMaker;

    @Column
    @NotBlank
    private String model;

    @Column("HORSEPOWER")
    @NotNull
    private int horsePower;

    @NotNull
    private int price;

    @Column("REGISTRATIONDATE")
    @NotNull
    private LocalDate registrationDate;

    public Car(Long id, String color, String carMaker, String model, int horsePower, int price, LocalDate registrationDate) {
        this.id = id;
        this.color = color;
        this.carMaker = carMaker;
        this.model = model;
        this.horsePower = horsePower;
        this.price = price;
        this.registrationDate = registrationDate;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(String carMaker) {
        this.carMaker = carMaker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
