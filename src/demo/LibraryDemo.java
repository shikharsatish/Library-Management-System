package demo;

import modal.*;

import java.util.List;
import java.util.Scanner;

public class LibraryDemo {
  static Scanner scanner = new Scanner(System.in);

  /**
   * User Input Operations to Add Books
   **/

  static void addBooks() {
    scanner.nextLine();
    System.out.println("Enter Book Name:");
    String title = scanner.nextLine();
    System.out.println("Enter Author Name:");
    String author = scanner.nextLine();
    System.out.println("Enter Category:");
    String category = scanner.nextLine();
    Category bookCategory = Category.valueOf(category.toUpperCase());
    System.out.println("Enter quantity");
    int quantity = scanner.nextInt();
    Book book = new Book(title, author, bookCategory, quantity);
    Library.addBookToLibrary(book);
    System.out.println("Book added successfully");
  }

  /**
   * User Input Operations to Search Books by Title
   **/

  static void searchBookByTitle() {
    System.out.println("Enter the Title:");
    scanner.nextLine();
    String bookTitle = scanner.nextLine();
    List<Book> bookByTitle = Library.searchBookByTitle(bookTitle);
    System.out.println(bookByTitle);
  }

  /**
   * User Input Operations to Search Books by Author Name
   **/

  static void viewBookByAuthor() {
    scanner.nextLine();
    System.out.println("Enter the Author Name:");
    String bookAuthor = scanner.nextLine();
    List<Book> viewByAuthor = Library.searchBookByAuthor(bookAuthor);
    System.out.println(viewByAuthor);
  }

  /**
   * View All books available in Library
   **/

  static void viewAllBooks() {
    List<Book> viewAll = Library.viewBookList();
    System.out.println(viewAll);
  }

  /**
   * Issue a Book
   **/

  static void issueBook() {
    scanner.nextLine();
    System.out.println("Enter book name:");
    String bookName = scanner.nextLine();
    System.out.println("Enter author name:");
    String authorName = scanner.nextLine();
    Library.issueBookToUser(bookName, authorName);
  }

  /**
   * Returning an previously issued book back to library
   **/
  static void returnBook() {
    scanner.nextLine();
    System.out.println("Enter book name:");
    String bookName = scanner.nextLine();
    System.out.println("Enter author name:");
    String authorName = scanner.nextLine();
    Library.returnBook(bookName, authorName);
  }

  /**
   * Search Book By Category
   */
  static void searchByCategory() {
    scanner.nextLine();
    System.out.println("Enter the category:");
    String category = scanner.nextLine();
    List<Book> bookCategory = Library.searchByCategory(category);
    System.out.println(bookCategory);
  }

  /**
   * Delete specific quantity of books
   */
  static void deleteBook() {
    scanner.nextLine();
    System.out.println("Enter author name:");
    String authorName = scanner.nextLine();
    System.out.println("Enter book name:");
    String bookName = scanner.nextLine();
    System.out.println("Enter quantity to remove:");
    int quantity = scanner.nextInt();
    Library.deleteBook(authorName, bookName, quantity);
  }

  /**
   * Main Method
   **/
  public static void main(String[] args) {

    /**
     *  Display Menu options to user
     **/

    boolean flag = true;
    while (flag) {
      System.out.print("1.Add Book\t\t");
      System.out.print("2.Search Book by Title\t\t");
      System.out.print("3.Search Book by Author\t\t");
      System.out.print("4.Search Book by Category\t\t");
      System.out.print("5.View All Books\t\t");
      System.out.print("6.Issue Book\t\t");
      System.out.print("7.Return Book\t\t");
      System.out.println("8.Delete Book\t\t");
      System.out.println("9.Exit");
      System.out.print("Enter choice:");

      /**
       * Declaring values for Switch Case
       **/

      final int ADD_BOOK = 1;
      final int SEARCH_BY_TITLE = 2;
      final int SEARCH_BY_AUTHOR = 3;
      final int SEARCH_BY_CATEGORY = 4;
      final int VIEW_ALL_BOOKS = 5;
      final int ISSUE_BOOK = 6;
      final int RETURN_BOOK = 7;
      final int DELETE = 8;
      final int EXIT = 9;

      Integer i = scanner.nextInt();

      switch (i) {
        case ADD_BOOK:
          addBooks();
          break;
        case SEARCH_BY_TITLE:
          searchBookByTitle();
          break;
        case SEARCH_BY_AUTHOR:
          viewBookByAuthor();
          break;
        case SEARCH_BY_CATEGORY:
          searchByCategory();
          break;
        case VIEW_ALL_BOOKS:
          viewAllBooks();
          break;
        case ISSUE_BOOK:
          issueBook();
          break;
        case RETURN_BOOK:
          returnBook();
          break;
        case DELETE:
          deleteBook();
          break;
        case EXIT:
          System.exit(0);
          flag = false;
      }
    }
  }
}

