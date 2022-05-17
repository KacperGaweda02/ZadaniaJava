import java.util.Scanner;
public class BookController {
    // to jest kontroler
    public static Scanner scanner = new Scanner(System.in);
    public static String input;
    public static String bookToRemove;
    public static String bookToSee;
    public static String newTitle;
    public static String newAuthor;
    public static String newGenre;
    public static String newDescrip;
    public static String blankValue;
    public static void letsGetStarted() {
        BookView.greeting();
        BookView.showMenu();
        input = scanner.next();
        BookService.doSomethingWithIt(input);
    }
    public static void askAndGive() {
        input = scanner.next();
        BookService.doSomethingWithIt(input);
    }
    public static void addBook() {
        System.out.println("What's the title?");
        blankValue = scanner.nextLine();
        newTitle = scanner.nextLine();
        System.out.println("Who is the author?");
        newAuthor = scanner.nextLine();
        System.out.println("What's the genre?");
        newGenre = scanner.nextLine();
        System.out.println("What's the description?");
        newDescrip = scanner.nextLine();
        BookService.createNewBook(newTitle, newAuthor, newGenre, newDescrip);
    }
    public static void getBookToRemove() {
        blankValue = scanner.nextLine();
        bookToRemove = scanner.nextLine();
        BookService.removeBook(bookToRemove);
    }
    public static void getSpecBook() {
        blankValue = scanner.nextLine();
        bookToSee = scanner.nextLine();
        BookService.showInfo(bookToSee);
    }
}
