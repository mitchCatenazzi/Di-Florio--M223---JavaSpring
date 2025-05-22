package ch.samt.customers.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq", sequenceName = "reservation_seq",allocationSize = 1)
    private Long id;

    // Join ManyToOne con entità customer
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @Size(min = 2, message = "Lunghezza minima di 2 caratteri")
    private String room;

    @Size(min = 2, message = "Lunghezza minima di 2 caratteri")
    private String checkin;

    @Size(min = 2, message = "Lunghezza minima di 2 caratteri")
    private String checkout;

}
