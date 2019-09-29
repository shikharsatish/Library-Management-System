package modal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
  Book book;

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  /**
   * Defining Singleton Class
   **/

  private static Library singleton = null;

  private Library() {
  }

  public static Library getInstance() {
    if (singleton == null) {
      singleton = new Library();
    }
    return singleton;
  }

  public static List<Book> bookList = new ArrayList<>();

  /**
   * List Operations
   **/

  public static void addBookToLibrary(Book book) {
    bookList.add(book);
  }

  /**
   * @param bookTitle
   * @return book title
   */
  public static List<Book> searchBookByTitle(String bookTitle) {
    return bookList.stream().filter(books -> books.getTitle().equalsIgnoreCase(bookTitle)).collect(Collectors.toList());
  }

  /**
   * @return list of all books
   */
  public static List<Book> viewBookList() {
    return bookList;
  }

  /**
   * @param bookAuthor
   * @return list of books having same author name
   */
  public static List<Book> searchBookByAuthor(String bookAuthor) {
    return bookList.stream().filter(author -> author.getAuthor().equalsIgnoreCase(bookAuthor)).collect(Collectors.toList());
  }

  /**
   * @param bookTitle
   * @param authorName
   */
  public static void issueBookToUser(String bookTitle, String authorName) {
    Book book = bookList.stream().filter(t -> t.getAuthor().equals(authorName) && t.getTitle().equals(bookTitle)).findFirst().get();
    if (book.getQuantity() > 0) {
      book.setQuantity(book.getQuantity() - 1);
      System.out.println("Book Issued");
    } else System.out.println("Book Not Issued");
  }

  /**
   * @param bookTitle
   * @param authorName
   */
  public static void returnBook(String bookTitle, String authorName) {
    Book book = bookList.stream().filter(t -> t.getAuthor().equals(authorName) && t.getTitle().equals(bookTitle)).findFirst().get();
    book.setQuantity(book.getQuantity() + 1);
    System.out.println("Book Returned");
    System.out.println("Please try another book");
  }

  /**
   * @param category
   * @return category of book
   */
  public static List<Book> searchByCategory(String category) {
    return bookList.stream().filter(c -> c.getCategory().name().equalsIgnoreCase(category)).collect(Collectors.toList());
  }

  /**
   * @param authorName
   * @param bookTitle
   * @param quantity
   */
  public static void deleteBook(String authorName, String bookTitle, int quantity) {
    Book book = bookList.stream().filter(t -> t.getTitle().equalsIgnoreCase(bookTitle) && t.getAuthor().equalsIgnoreCase(authorName)).findFirst().get();
    if (book.getQuantity() > 0)
    book.setQuantity(book.getQuantity() - quantity);
    System.out.println("Book Deleted");
  }
}


