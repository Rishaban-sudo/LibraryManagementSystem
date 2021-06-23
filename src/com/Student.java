package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Student {
    private String name;
    private String rollNo;
    private ArrayList<Book> books;

    public Student(String name,String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public Book returnBook() {
        int bookId;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the book id to be returned :");
        bookId= sc.nextInt();

        for(Iterator<Book> itr= books.iterator(); itr.hasNext();) {
            Book book = itr.next();
            if(book.getBookId().equals(bookId)) {
                itr.remove();
                return book;
            }
        }
        return null;
    }

    public int noOfBooks() {
        return books.size();
    }

    public void displayBookList() {
        if (books.size() > 0) {
            books.forEach(System.out::println);
        }
        else {
            System.out.println("No books !");
        }
    }


    @Override
    public boolean equals(Object o) {
        if(this==o) {
            return true;
        }
        if(o!=null && this.getClass()!=o.getClass()) {
            return false;
        }
        Student student = (Student) o;

        return this.rollNo.equals(student.rollNo);
    }

    @Override
    public int hashCode() {
        return rollNo.hashCode();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", books=" + books +
                '}';
    }
}
