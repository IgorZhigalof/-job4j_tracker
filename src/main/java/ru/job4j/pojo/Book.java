package ru.job4j.pojo;

public class Book {
    private String title;
    private int countOfPages;

    public Book(String title, int countOfPages) {
        this.title = title;
        this.countOfPages = countOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }
}
