package ch.samt.esercizio2product.domain;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Product {

    private Integer id;

    @NotBlank(message = "Il nome non può essere vuoto")
    private String name;

    @NotNull(message = "Il prezzo non può essere nullo")
    @Positive(message = "Il prezzo deve essere maggiore di zero")
    private BigDecimal price;

    @FutureOrPresent(message = "La data di scadenza deve essere nel presente o nel futuro")
    private LocalDate expirationDate;

    public Product(Integer id, String name, BigDecimal price, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
