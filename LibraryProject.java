class Library {
    private String[] books;
    private String[] issuedBooks;
    private int no_of_Books;
    private int no_of_IssuedBooks;

    // Constructor
    Library() {
        this.books = new String[50];
        this.issuedBooks = new String[50];
        this.no_of_Books = 0;
        this.no_of_IssuedBooks = 0;
    }

    // Sleep method
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.println("Error!");
        }
    }

    // Add a new book
    public void addBook(String book) {
        this.books[no_of_Books++] = book;
        System.out.println("Processing...");
        sleep(3000);
        System.out.println(book + " is added to the library.");
    }

    // Show all available books
    public void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (String item : books) {
            if (item != null) {
                System.out.println("--> " + item);
            }
        }
    }

    // Issue a book
    public void issueBook(String book, String issuedPersonName, int bookIssuedForDays) {
        this.issuedBooks[no_of_IssuedBooks++] = book;
        System.out.println(book + " has been issued to " + issuedPersonName
                + " for " + bookIssuedForDays + " days.");
    }

    // Return a book
    public void returnBook(String book, int returnedInDays, String personName) {
        int fine = 0;
        if (returnedInDays <= 15) {
            System.out.println(book + " is returned by " + personName
                    + " in " + returnedInDays + " days.");
        } else {
            fine = (returnedInDays - 15) * 50;
            System.out.println(personName + " returned " + book
                    + "\nTotal late Fine = Rs." + fine);
        }
    }
}

// Main class
public class LibraryProject {
    public static void main(String[] args) {
        Library lib = new Library();

        // Add books
        lib.addBook("Zero To One");
        lib.addBook("Rich Dad Poor Dad");
        lib.addBook("Introduction to Algorithms");

        // Show available books
        lib.showAvailableBooks();

        // Issue a book
        lib.issueBook("Rich Dad Poor Dad", "Tarun Chaudhary", 15);

        // Return a book
        lib.returnBook("Rich Dad Poor Dad", 20, "Tarun Chaudhary");
    }
}
