package modal;

public class Book {
  private String title;
  private String author;
  private Category category;
  private int quantity;
  private int id;

  public int getQuantity() {
    return quantity;
  }

  public Book() {
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Book(String title, String author, Category category, int quantity) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.category = category;
    this.quantity = quantity;

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  /**
   * Overriding toString method of Object Class
   **/
  @Override
  public String toString() {
    return "\nTitle: " + this.title + "\nAuthor: " + this.author + "\nBook Category: " + this.category + "\nQuantity: " + this.quantity;
  }

  /**
   * Overriding equals method of Object Class
   **/
  @Override
  public boolean equals(Object object) {
    boolean result = false;
    if (object == null || object.getClass() != this.getClass()) {
      result = false;
    } else {
      Book book = (Book) object;
      if (this.title.equals(book.getTitle()) && this.author.equals(book.getAuthor())) {
        result = true;
      }
    }
    return result;
  }
}

