package ch.samt.musicContest.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "singer_seq")
    @SequenceGenerator(name = "singer_seq", sequenceName = "singer_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Column(name = "MUSICALGENRE")
    private String musicalGenre;


    private Integer votes;

    public Singer() {
    }

    public Singer(Long id, String name, String surname, String musicalGenre, Integer votes) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.musicalGenre = musicalGenre;
        this.votes = votes;
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



    public String getMusicalGenre() {
        return musicalGenre;
    }

    public void setMusicalGenre(String musicalGenre) {
        this.musicalGenre = musicalGenre;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

}
