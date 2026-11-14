public class Book {
    private String title;
    private String author;
    private boolean borrowed = false;      // only ONE copy of each title

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle()  { return title; }
    public String getAuthor() { return author; }

    // Returns the message shown at the bottom of the Borrow Book window
    public String borrowBy(Student s) {
        if (borrowed)
            return "Sorry, " + title + " has already been borrowed.";
        if (s.hasBorrowed())
            return s.getName() + " has already borrowed one book.";

        borrowed = true;
        s.setBorrowed(true);
        return s.getName() + " with matric number " + s.getMatric()
             + " has borrow a book with title " + title + ".";
    }

    // The combo box shows this text
    public String toString() {
        return title + " (" + author + ")";
    }
}
