package ch.samt.libraryManager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
@Table(name="MYUSER")
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @Column(name="BORROWEDBOOKS")
    private Integer borrowedBooks;

    public MyUser() {
    }

    public MyUser(Long id, String name, String surname, String email, Integer borrowedBooks) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.borrowedBooks = borrowedBooks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBorrowedBooks(Integer borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

}
