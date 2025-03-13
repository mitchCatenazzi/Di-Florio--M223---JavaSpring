package ch.samt.Customers.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

//@Data
//@AllArgsConstructor
public class Customer {


    //@NotNull
    @Id
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20,message = "lunghezza da 2 a 20 caratteri")
    private String name;

    @NotBlank
    @Size(min = 2, max = 20,message = "lunghezza da 2 a 20 caratteri")
    private String surname;

    private String gender;

    private Integer age;

    public Customer(Long id, String name, String surname, String gender, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }

    public Customer(Long id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public Customer(Long id) {
        this.id = id;
    }

    public Customer() {

    }

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


