package ch.samt.Customers.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.math.BigInteger;


@Data
@AllArgsConstructor //costruttore con gli attributi
@NoArgsConstructor // costruttore vuoto
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "customer_seq")
    @SequenceGenerator(name ="customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Integer id;
    @NotNull
    @Size(min = 2, max = 10, message = "Lunghezza tra 2 e 10 caratteri")
    private String name;
    @NotNull
    @Size(min = 2, max = 10, message = "Lunghezza tra 2 e 10 caratteri")
    private String surname;
    private String gender;
    @NotNull
    @Min(18)
    @Max(99)
    private Integer age;


}
