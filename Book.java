public class Book{
    private String title;
    private String author;
    private String genre;
    private boolean isBorrowed;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "" +
                "genre: " + genre + "\n" +
                "Name of the book: " + title + "\n" +
                "Author's name: " + author + "\n" +
                "is borrowed: " + isBorrowed + "\n";
    }
}