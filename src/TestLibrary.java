import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestLibrary {
   Library library = new Library();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printOptions();
            System.out.print("Pick an option: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                scanner.next(); // discard invalid input
                printOptions();
                System.out.print("Pick an option: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter year published: ");
                    String year = scanner.nextLine();
                    System.out.print("Enter number of copies: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine();
                    library.addBook(new Book(author, name, year, copies));
                    break;

                case 2:
                    System.out.print("Enter book name to remove: ");
                    String removeName = scanner.nextLine();
                    boolean removed = library.removeBook(removeName);
                    if (removed) {
                        System.out.println("Book removed or updated.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter book name/s to borrow(comma-separated): ");
                    String borrowNames = scanner.nextLine();
                    List<String> returnList = Arrays.stream(borrowNames.split(",")).map(String::trim)
                                                        .filter(s->!s.isEmpty()).toList();
                     library.issueBooks(returnList);
                    break;

                case 4:
                    System.out.print("Enter book name/s to return(comma-separated): ");
                    String returnNames = scanner.nextLine();
                    List<String> returnedBooks = Arrays.stream(returnNames.split(",")).map(String::trim)
                                                        .filter(s->!s.isEmpty()).toList();
                    library.returnBooks(returnedBooks);
                    break;

                case 5:
                    library.getLibrarySummary();
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }

        } while (choice != 6);
    }

    public void printOptions() {
        System.out.println("\n===== Library Management System =====");
        System.out.println("1. Add a Book");
        System.out.println("2. Remove a Book");
        System.out.println("3. Borrow a Book");
        System.out.println("4. Return Book");
        System.out.println("5. Show Library Summary");
        System.out.println("6. Exit");
    } 
}
