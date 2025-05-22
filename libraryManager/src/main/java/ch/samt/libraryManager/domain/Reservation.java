package ch.samt.libraryManager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq", sequenceName = "reservation_seq", allocationSize = 1)
    private Long id;

    // Join ManyToOne, entità utente
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private MyUser MYUser;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name="REGISTRATIONDATE")
    @NotNull
    private LocalDate registrationDate;

    @Column(name="EXPIRATIONDATE")
    @NotNull
    private LocalDate expirationDate;

    public Reservation() {
    }

    public Reservation(Long id, MyUser MYUser, Book book, LocalDate registrationDate, LocalDate expirationDate) {
        this.id = id;
        this.MYUser = MYUser;
        this.book = book;
        this.registrationDate = registrationDate;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MyUser getMYUser() {
        return MYUser;
    }

    public void setMYUser(MyUser MYUser) {
        this.MYUser = MYUser;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
