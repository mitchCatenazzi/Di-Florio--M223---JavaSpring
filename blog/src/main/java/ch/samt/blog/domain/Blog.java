package ch.samt.blog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "blog_seq")
    @SequenceGenerator(name ="blog_seq", sequenceName = "blog_seq", allocationSize = 1)
    private Integer id;

    @NotNull
    private String title;


    @Column(name = "PUBLISHEDDATE")
    private LocalDate publishedDate;

    @NotNull
    private String category;

    @NotNull
    private String author;

    @NotNull
    private Integer likes;

    @Lob
    private String content;

    public Blog(Integer id, String title, LocalDate publishedDate, String category, String author, Integer likes, String content) {
        this.id = id;
        this.title = title;
        this.publishedDate = publishedDate;
        this.category = category;
        this.author = author;
        this.likes = likes;
        this.content = content;
    }

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
