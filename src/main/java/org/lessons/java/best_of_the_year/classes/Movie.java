package org.lessons.java.best_of_the_year.classes;

public class Movie {

    private int id;
    private String title;

    // constructor
    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // toString
    @Override
    public String toString() {
        return "Movie{" +
                "id: " + id +
                ", title: '" + title + '\'' +
                '}';
    }

}
