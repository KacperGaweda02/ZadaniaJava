import java.io.FileWriter;
import java.io.IOException;
public class BookService {
    // to jest model
    static boolean isWorking = true;
    public static void doSomethingWithIt(String input) {
        while (isWorking) {
            switch (input) {
                case "1":
                    input = "0";
                    showTitles();
                    break;
                case "2":
                    input = "0";
                    BookController.addBook();
                    break;
                case "3":
                    input = "0";
                    bookRemoval();
                    break;
                case "4":
                    input = "0";
                    viewInfo();
                    break;
                case "5":
                    input = "0";
                    saveInFile();
                    break;
                case "6":
                    input = "0";
                    isWorking = false;
                    break;
                default:
                    input = "0";
                    BookView.getMad();
                    break;
            }
        }
    }
    public static void showTitles() {
        for (int i = 0; i<BookRepository.listOfBooks.size(); i++) {
            BookView.printTitles(i);
        }
        BookView.showMenu();
        BookController.askAndGive();
    }
    public static void createNewBook(String title, String author, String genre, String descrip) {
        BookRepository.listOfBooks.add(new Book(title, author, genre, descrip));
        BookView.showMenu();
        BookController.askAndGive();
    }
    public static void bookRemoval() {
        BookView.askAboutBookRemoval();
        for (int i = 0; i < BookRepository.listOfBooks.size(); i++) {
            BookView.printTitles(i);
        }
        BookController.getBookToRemove();
    }
    public static void removeBook(String bookToRemove) {
        int isRemoved = 0;
        for (int i = 0; i<BookRepository.listOfBooks.size(); i++) {
            if (BookRepository.listOfBooks.get(i).name.equals(bookToRemove)) {
                BookRepository.listOfBooks.remove(i);
                isRemoved++;
            }
        }
        if (isRemoved==0) {
            BookView.noSuchABook();
        }
        BookView.showMenu();
        BookController.askAndGive();
    }
    public static void viewInfo() {
        BookView.askAboutSpecBook();
        for (int i = 0; i<BookRepository.listOfBooks.size(); i++) {
            BookView.printTitles(i);
        }
        BookController.getSpecBook();
    }
    public static void showInfo(String bookToSee) {
        int isExisting = 0;
        for (int i = 0; i<BookRepository.listOfBooks.size(); i++) {
            if (BookRepository.listOfBooks.get(i).name.equals(bookToSee)) {
                BookView.showDetails(BookRepository.listOfBooks.get(i).name, BookRepository.listOfBooks.get(i).author, BookRepository.listOfBooks.get(i).genre, BookRepository.listOfBooks.get(i).descrip);
                isExisting++;
            }
        }
        if (isExisting==0) {
            BookView.noSuchABook();
        }
        BookView.showMenu();
        BookController.askAndGive();
    }
    public static void saveInFile() {
        try {
            FileWriter writer = new FileWriter("books_in_library.txt");
            writer.write("title:" + BookRepository.listOfBooks.get(0).name + " author:" + BookRepository.listOfBooks.get(0).author + " genre:" + BookRepository.listOfBooks.get(0).genre + " description:" + BookRepository.listOfBooks.get(0).descrip + "\n");
            for (int i=1; i<BookRepository.listOfBooks.size(); i++) {
                writer.append("title:").append(BookRepository.listOfBooks.get(i).name).append(" author:").append(BookRepository.listOfBooks.get(i).author).append(" genre:").append(BookRepository.listOfBooks.get(i).genre).append(" description:").append(BookRepository.listOfBooks.get(i).descrip).append("\n");
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        BookView.showMenu();
        BookController.askAndGive();
    }
}
