import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    Map<String,Book> library = new HashMap<>();
    

    // add or increase count 
    public void addBook(Book book){
      String key = book.getBookName().toLowerCase();
      if(library.containsKey(key)){
        library.get(key).increaseAvailable(book.getBooksAvailable());
      }else{
        library.put(key,book);
      }
      System.out.println("Book \"" + book.getBookName() + "\" added successfully.");
    }
     

    //remove a copy or book
    public boolean removeBook(String bookname){
      String key = bookname.toLowerCase();
      Book book = library.get(key);
      if(book == null) return false;
      if(book.getBooksAvailable() > 1){
        book.decreaseAvailable();
      }else{
        library.remove(key);
      }
      return true;
    }

    //issue a book/s
    public void issueBooks( List<String> books){
      for(String bookName: books){
        Book book = library.get(bookName.toLowerCase());
        if(book == null){
            System.out.println("Bppk \""+ bookName +"\" not found in the library");
            continue;
        }
        if(book.getBooksAvailable()> 0){
            book.borrowBook();
            System.out.println("Issued \"" + book.getBookName() + "\" successfully.");
        }else{
            System.out.println("No available copies of \"" + book.getBookName() + "\" to issue.");  
        }
        
      }
    }
    
    //return  a book/s
    public void returnBooks(List<String> books) {
        for (String bookName : books) {
            Book book = library.get(bookName.toLowerCase());
    
            if (book == null) {
                System.out.println("Book \"" + bookName + "\" not found in the library.");
                continue;
            }
    
            if (book.getBorrowedBooks() > 0) {
                book.returnBook();
                System.out.println("Returned \"" + book.getBookName() + "\" successfully.");
            } else {
                System.out.println("No borrowed copies of \"" + book.getBookName() + "\" to return.");
            }
        }
    }
    
    // print books summary
    public void getLibrarySummary(){
      if (library.isEmpty()) {
        System.out.println("The library is currently empty.");
        return;
      }

      System.out.println("\n===== Library Summary =====");
      System.out.printf("%-30s %-20s %-10s %-10s %-10s%n", "Title", "Author", "Year", "Available", "Borrowed");
      System.out.println("----------------------------------------------------------------------");

      for (Book book : library.values()) {
          System.out.printf("%-30s %-20s %-10s %-10d %-10d%n",
                  book.getBookName(),
                  book.getAuthor(),
                  book.getYearPublished(),
                  book.getBooksAvailable(),
                  book.getBorrowedBooks()
          );
      }
      System.out.println("----------------------------------------------------------------------");
    }
}
