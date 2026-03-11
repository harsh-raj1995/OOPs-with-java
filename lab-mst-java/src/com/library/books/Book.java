package com.library.books;

public class Book {
  private int bookId;
  private String title;
  private String author;
  private int availableCopies;

  Book(int id,String t,String a,int c){
    this.bookId=id;
    this.title=t;
    this.author=a;
    this.availableCopies=c;
  }

  public int getBookId() {
      return bookId;
  }
  public String getTitle() {
    return title;
  }
  public String getAuthor() {
    return author;
  }
  public int getAvailableCopies() {
    return availableCopies;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setAvailableCopies(int availableCopies) {
    this.availableCopies = availableCopies;
  }

  public void displayBook() {
    System.out.println("Book Information \n");
    System.out.println("Book ID: " + bookId);
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("Available Copies: " + availableCopies);
  }

}
