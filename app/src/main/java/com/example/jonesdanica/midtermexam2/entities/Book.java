package com.example.jonesdanica.midtermexam2.entities;

/**
 * Created by danica12 on 2/23/2016.
 */
public class Book {
    private String id;
    private String title;
    private String genre;
    private String author;
    private boolean isRead;

    public Book() {
    }

    public Book(String title, boolean isRead) {
        this.title = title;
        this.isRead = isRead;
    }

    public Book(String id, String title, String genre, String author, boolean isRead) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.isRead = isRead;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}
