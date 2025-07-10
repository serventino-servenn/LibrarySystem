# Library Management System

A simple console-based Java application to manage a library's collection of books, supporting adding, removing, borrowing, returning, and viewing book summaries.


## Features

- Add new books or increase the number of copies of existing books  
- Remove copies or entire books from the library  
- Borrow (issue) books if available  
- Return borrowed books  
- View a summary of all books with details on availability and borrowed copies  


## How to Use

1. Compile the project (all `.java` files):
    ```bash
    javac Main.java Library.java Book.java TestLibrary.java

2.  Run the program:
    ```bash
    java Main

3. Follow the on-screen menu prompts.
    Note: This program assumes the user will enter correct inputs

- Numeric inputs for number of copies
- Book names and authors as text without empty strings
- Multiple books for borrow/return operations separated by commas(eg.,Book1,Book2,Book3)

## Project Structure
- Main.java : Entry point that starts the CLI interface
- TestLibrary.java: Handles user input and display menu options
- Library.java: Contains code logic for managing books
- Book.java: Represents a book with details like author,title,year, and availability

## Limitations
- Minimal input validation(assumes correct input)
- No persistent storage
- No user authentication or tracking of who borrows books


## Future Improvements
- add input validation with error handling
- Persist libray data to a file or database
- Implement user management and borrowing history
- Add GUI interface using JavaFx or Swing

## License
This project is open-source and free to use 
