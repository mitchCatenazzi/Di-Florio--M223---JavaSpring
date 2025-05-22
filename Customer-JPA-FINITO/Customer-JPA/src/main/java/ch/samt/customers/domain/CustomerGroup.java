package ch.samt.customers.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class CustomerGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customergroup_seq")
    @SequenceGenerator(name = "customergroup_seq", sequenceName = "customergroup_seq")
    private Long id;

    // Join ManyToMany con entità customer
    @ManyToMany(mappedBy = "customerGroups")
    private List<Customer> customers;

    @NotBlank
    @Size(min = 2, message = "Lunghezza minima di 2 caratteri")
    private String name;

    @NotBlank
    @Size(min = 2, message = "Lunghezza minima di 2 caratteri")
    private String description;
}
