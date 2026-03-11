package com.library.service;

import com.library.books.Book;
import com.library.exception.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class LibraryService {

    String file="books.txt";

    public void addBook(Book b) throws Exception {

        FileWriter fw = new FileWriter(file,true);

        fw.write(b.getBookId()+","+b.getTitle()+","+b.getAuthor()+","+b.getAvailableCopies()+"\n");

        fw.close();
    }

    public void viewBooks() throws Exception {

        FileReader fr = new FileReader(file);
        Scanner sc = new Scanner(fr);

        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

        fr.close();
    }

    public void issueBook(int bookId) throws Exception {

        FileReader fr = new FileReader(file);
        Scanner sc = new Scanner(fr);

        String data="";
        boolean found=false;

        while(sc.hasNextLine()){

            String line=sc.nextLine();
            String[] b=line.split(",");

            int id=Integer.parseInt(b[0]);
            int copies=Integer.parseInt(b[3]);

            if(id==bookId){

                found=true;

                if(copies==0){
                    throw new BookNotAvailableException("Book not available");
                }

                copies--;
                line=id+","+b[1]+","+b[2]+","+copies;
            }

            data=data+line+"\n";
        }

        fr.close();

        if(!found){
            throw new BookNotFoundException("Book not found");
        }

        FileWriter fw=new FileWriter(file);
        fw.write(data);
        fw.close();
    }

    public void returnBook(int bookId) throws Exception {

        FileReader fr=new FileReader(file);
        Scanner sc=new Scanner(fr);

        String data="";
        boolean found=false;

        while(sc.hasNextLine()){

            String line=sc.nextLine();
            String[] b=line.split(",");

            int id=Integer.parseInt(b[0]);
            int copies=Integer.parseInt(b[3]);

            if(id==bookId){

                found=true;
                copies++;

                line=id+","+b[1]+","+b[2]+","+copies;
            }

            data=data+line+"\n";
        }

        fr.close();

        if(!found){
            throw new BookNotFoundException("Book not found");
        }

        FileWriter fw=new FileWriter(file);
        fw.write(data);
        fw.close();
    }
}