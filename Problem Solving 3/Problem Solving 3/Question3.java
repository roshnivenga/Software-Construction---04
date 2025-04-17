public class Book {
    private String title;
    private boolean isAvailable;
    private String borrower;

    public Book(String title) {
        assert title != null && !title.isEmpty() : "Title must not be null or empty";
        this.title = title;
        this.isAvailable = true;
        this.borrower = null;
    }

    public void borrow(String user) {
        // Pre-conditions
        assert isAvailable : "Book is already borrowed.";
        assert user != null && !user.isEmpty() : "User must be valid.";

        // Process
        this.isAvailable = false;
        this.borrower = user;

        // Post-conditions
        assert !isAvailable : "Book should now be unavailable.";
        assert this.borrower.equals(user) : "Borrower not recorded properly.";
    }

    public void returnBook() {
        // Pre-condition
        assert !isAvailable : "Book is not currently borrowed.";
        assert borrower != null : "No borrower info found.";

        // Process
        this.isAvailable = true;
        this.borrower = null;

        // Post-condition
        assert isAvailable : "Book should now be available.";
        assert borrower == null : "Borrower info should be cleared.";
    }

    public String getStatus() {
        return isAvailable ? "Available" : "Borrowed by " + borrower;
    }

    public static void main(String[] args) {
        Book book = new Book("Clean Code");
        System.out.println("Before: " + book.getStatus());

        book.borrow("Ali");
        System.out.println("After borrow: " + book.getStatus());

        book.returnBook();
        System.out.println("After return: " + book.getStatus());
    }
}
