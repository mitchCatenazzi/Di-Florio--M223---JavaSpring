package ch.samt.musicContest.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Judge {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "judge_seq")
    @SequenceGenerator(name = "judge_seq", sequenceName = "judge_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    private String name;


    @NotBlank
    private String surname;


    @Column(name="HASVOTED")
    private Boolean hasVoted;

    public Judge() {
    }

    public Judge(Long id, String name, String surname, Boolean hasVoted) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.hasVoted = hasVoted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(Boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

}
