package ch.samt.gardenwarehouse.Domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class item {

    private long id;

    private String code;
    private String type;
    private String name;
    private BigDecimal price;

    @Pattern(regexp = "^[a-zA-Z]{3}-\\d{2}$", message = "Formato non valido. Deve essere 'abc-12'")
    private String position;

    private long itemCount;

}
