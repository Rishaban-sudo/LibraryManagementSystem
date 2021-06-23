package com;

import java.util.HashMap;
import java.util.Scanner;

public class Library {
    private String name;
    private HashMap<Integer,Book> books;
    private HashMap<Integer,Book> scrapArea;
    private HashMap<String,Student> memberStudents;

    Library(String name) {
        this.name = name;
        books = new HashMap<>();
        scrapArea = new HashMap<>();
        memberStudents = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook() {
        String name,author;
        int bookId;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter book name : ");
        name=sc.nextLine();


        System.out.println("Enter author name : ");
        author=sc.nextLine();


        System.out.println("Enter book id : ");
        bookId = sc.nextInt();

        books.put(bookId,new Book(name,author, bookId));
        System.out.println("Book added successfully!");
    }

    public void getBookInfo() {
        int bookId;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter book id : ");
        bookId = sc.nextInt();

        if(books.containsKey(bookId)) {
            System.out.println( books.get(bookId) );
        }
        else {
            System.out.println("Book does not exists");
        }

    }

    public void regStudent() {
        String name,rollNo;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name : ");
        name = sc.nextLine();

        System.out.println("Enter your roll number : ");
        rollNo = sc.next();

        if(memberStudents.containsKey(rollNo)) {
            System.out.println("Student is already a member!");
        }
        else{
            memberStudents.put(rollNo, new Student(name, rollNo));
            System.out.println("Successfully registered");
        }

    }

    public void lendBook() {
        String rollNo;
        int bookId;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the student roll number to lend the book :");
        rollNo=sc.next();

        System.out.println("Enter the book id : ");
        bookId = sc.nextInt();

        Student student = memberStudents.get(rollNo);
        if(student.noOfBooks()>=5) {
            System.out.println("Exceeded the maximum number of book count !");
        }
        else {
            Book book = books.get(bookId);
            book.incrementNoOfTimesLendedCount();
            student.addBook(book);
            books.remove(bookId);
            System.out.println("Book lended successfully!");
        }

    }

    public void returnBook() {
        String rollNo;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the student roll number :");
        rollNo= sc.next();

        if( memberStudents.containsKey(rollNo) ) {
            Book book = memberStudents.get(rollNo).returnBook();
            if(book.getNoOfTimesLended()>=100) {
                scrapArea.put(book.getBookId(), book);
            }
            else {
                books.put(book.getBookId(), book);
            }
        }
        else {
            System.out.println("Invalid student roll number !");
        }


    }

    public void getStudentBookList() {
        String rollNo;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the student roll number reg with library :");
        rollNo= sc.next();

        if(memberStudents.containsKey(rollNo)) {
            memberStudents.get(rollNo).displayBookList();
        }
        else {
            System.out.println("The Student does not exist");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return name.equals(library.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
