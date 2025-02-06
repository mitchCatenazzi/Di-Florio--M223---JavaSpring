package ch.sam.Book.List;


//fa getter e setter automaticamente, fa costruttori, fa il Tostring()
import lombok.Data;

@Data
public class Book {

    private long id;

    private String title;

    private String author;




}
