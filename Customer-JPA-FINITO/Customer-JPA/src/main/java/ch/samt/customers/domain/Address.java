package ch.samt.customers.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq")
    private Long id;

    @Size(min = 2, message = "Lunghezza minima di 2 caratteri")
    private String street;

    @Size(min = 1, message = "Lunghezza minima di 1 carattere")
    private String num;

    @Size(min = 2, message = "Lunghezza minima di 2 caratteri")
    private String zip;

    @Size(min = 2, message = "Lunghezza minima di 2 caratteri")
    private String city;

    @Size(min = 2, message = "Lunghezza minima di 2 caratteri")
    private String nation;

}
