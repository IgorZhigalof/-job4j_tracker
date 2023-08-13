package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("first book", 300);
        books[1] = new Book("second book", 400);
        books[2] = new Book("third book", 500);
        books[3] = new Book("Clean code", 500);
        for (int i = 0; i < books.length; i++) {
            System.out.println("Title: " + books[i].getTitle()
                                + "   Count of pages: " + books[i].getCountOfPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println("Title: " + books[i].getTitle()
                    + "   Count of pages: " + books[i].getCountOfPages());
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals("Clean code")) {
                System.out.println("Title: " + books[i].getTitle()
                        + "   Count of pages: " + books[i].getCountOfPages());
            }
        }
    }
}
