package ch.samt.collectionGame.domain;


public class Game {

    private String title;

    private String type;

    private Integer id;

    private Integer price;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Game(Integer id, String title, String type,  Integer price) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.price = price;
    }

    public Game() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }






}
