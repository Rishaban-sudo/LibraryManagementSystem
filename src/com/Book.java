package com;


public class Book {
    private String name;
    private String author;
    private Integer bookId;
    private int noOfTimesLended;


    public Book(String name, String author, Integer bookId) {
        this.name = name;
        this.author = author;
        this.bookId = bookId;
    }

    public void incrementNoOfTimesLendedCount() {
        noOfTimesLended++;
    }

    public Integer getBookId() {
        return bookId;
    }

    public int getNoOfTimesLended() {
        return noOfTimesLended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId.equals(book.bookId) ;
    }

    @Override
    public int hashCode() {
        return name.hashCode()+author.hashCode()+bookId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", bookId=" + bookId +
                ", noOfTimesLended=" + noOfTimesLended +
                '}';
    }
}
