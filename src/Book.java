class Book{
    private String author;
    private String bookName;
    private String yearPublished;
    private int booksAvailable;
    private int borrowedBooks;
    
    public Book(String author,String bookName,String yearPublished,int booksAvailable){
      this.author = author;
      this.bookName = bookName;
      this.yearPublished = yearPublished;
      this.booksAvailable = booksAvailable;
      this.borrowedBooks = 0;
    }

    // Getters
    public String getAuthor() { 
      return author; 
    }
    public String getBookName() {
       return bookName;
    }
    public String getYearPublished() {
       return yearPublished;
     }
    public int getBooksAvailable() {
       return booksAvailable; 
    }
    public int getBorrowedBooks() {
       return borrowedBooks; 
    }

    // Setters and updaters
    public void increaseAvailable(int count) {
        this.booksAvailable += count;
    }

    public void decreaseAvailable() {
        if (booksAvailable > 0) this.booksAvailable--;
    }

    public void borrowBook() {
        this.decreaseAvailable();
        this.borrowedBooks++;
    }

    public void returnBook() {
        if (borrowedBooks > 0) {
            this.borrowedBooks--;
            this.booksAvailable++;
        }
    }
    
      
  }