package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library lib = new Library("MG");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Library Management System");

        while(true) {
            System.out.println("--------------------------------------------");
            System.out.println("Enter your choice");
            System.out.println("1.Add a book to the library ");
            System.out.println("2.View book info (if available in library) ");
            System.out.println("3.Register student with the library");
            System.out.println("4.Lend a book to student ");
            System.out.println("5.Return back a book to library ");
            System.out.println("6.Get the list of books borrowed by a particular student ");
            System.out.println("7.Exit");

            int ch=0;

            try {
                ch= scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a number to confirm your choice !");
                scanner.nextLine();
                continue;
            }


            switch (ch) {
                case 1:
                    lib.addBook();
                    break;
                case 2:
                    lib.getBookInfo();
                    break;
                case 3:
                    lib.regStudent();
                    break;
                case 4:
                    lib.lendBook();
                    break;
                case 5:
                    lib.returnBook();
                    break;
                case 6:
                    lib.getStudentBookList();
                    break;
                default:
                    scanner.close();
                    System.exit(0);
            }

        }

    }
}
