package com.library.main;

import com.library.books.Book;
import com.library.service.LibraryService;
import com.library.exception.BookNotAvailableException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        LibraryService service=new LibraryService();

        try{

            System.out.println("Enter Book ID");
            int id=sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Title");
            String title=sc.nextLine();

            System.out.println("Enter Author");
            String author=sc.nextLine();

            System.out.println("Enter Copies");
            int copies=sc.nextInt();

            Book b=new Book(id,title,author,copies);

            service.addBook(b);

            System.out.println("Books in Library");
            service.viewBooks();

            System.out.println("Enter Book ID to issue");
            int issue=sc.nextInt();
            service.issueBook(issue);

            System.out.println("Enter Book ID to return");
            int ret=sc.nextInt();
            service.returnBook(ret);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}