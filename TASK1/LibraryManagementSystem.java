import java.util.*;
class Author {
 private String name;
 public Author(String name) {
 this.name = name;
 }
 public String getName() {
 return name;
 }
}
class Book {
 private String title;
 private Author author;
 private boolean isBorrowed;
 public Book(String title, Author author) {
 this.title = title;
 this.author = author;
 this.isBorrowed = false;
 }
 public String getTitle() {
 return title;
 }
 public Author getAuthor() {
 return author;
 }
 public boolean isBorrowed() {
 return isBorrowed;
 }
 public void borrow() {
 if (!isBorrowed) {
 isBorrowed = true;
 }
 }
 public void returnBook() {
 isBorrowed = false;
 }
 @Override
 public String toString() {
 return title + " by " + author.getName() + (isBorrowed ? " [Borrowed]" : " [Available]");
 }
}
class Library {
 private List<Book> books = new ArrayList<>();
 public void addBook(String title, String authorName) {
 Author author = new Author(authorName);
 Book book = new Book(title, author);
 books.add(book);
 System.out.println("Book added: " + book);
 }
 public void displayBooks() {
 if (books.isEmpty()) {
 System.out.println("No books in library.");
 return;
 }
 System.out.println("\nBooks in Library:");
 for (Book book : books) {
 System.out.println(book);
 }
 }
 public void borrowBook(String title) {
 for (Book book : books) {
 if (book.getTitle().equalsIgnoreCase(title)) {
 if (!book.isBorrowed()) {
 book.borrow();
 System.out.println("You borrowed: " + book.getTitle());
 return;
 } else {
 System.out.println("Sorry, the book is already borrowed.");
 return;
 }
 }
 }
 System.out.println("Book not found.");
 }
 public void returnBook(String title) {
 for (Book book : books) {
 if (book.getTitle().equalsIgnoreCase(title)) {
 if (book.isBorrowed()) {
 book.returnBook();
 System.out.println("Book returned: " + book.getTitle());
 return;
 } else {
 System.out.println("This book wasn't borrowed.");
 return;
 }
 }
 }
 System.out.println("Book not found.");
 }
}
public class LibraryManagementSystem {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 Library library = new Library();
 int choice;
 do {
 System.out.println("\n=== Library Menu ===");
 System.out.println("1. Add Book");
 System.out.println("2. Display Books");
 System.out.println("3. Borrow Book");
 System.out.println("4. Return Book");
 System.out.println("0. Exit");
 System.out.print("Enter choice: ");
 choice = scanner.nextInt();
 scanner.nextLine(); // consume newline
 switch (choice) {
 case 1:
 System.out.print("Enter Book Title: ");
 String title = scanner.nextLine();
 System.out.print("Enter Author Name: ");
 String author = scanner.nextLine();
 library.addBook(title, author);
 break;
 case 2:
 library.displayBooks();
 break;
 case 3:
 System.out.print("Enter title to borrow: ");
 String borrowTitle = scanner.nextLine();
 library.borrowBook(borrowTitle);
 break;
 case 4:
 System.out.print("Enter title to return: ");
 String returnTitle = scanner.nextLine();
 library.returnBook(returnTitle);
 break;
 case 0:
 System.out.println("Exiting...");
 break;
 default:
 System.out.println("Invalid choice.");
 }
 } while (choice != 0);
 scanner.close();
 }
}