package ch.samt.Customers.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

//@Data
public class Customer {

    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20,message = "lunghezza da 2 a 20 caratteri")
    private String name;

    @NotBlank
    @Size(min = 2, max = 20,message = "lunghezza da 2 a 20 caratteri")
    private String surname;


    private String gender;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}


