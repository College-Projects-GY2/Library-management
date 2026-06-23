public class Book{
    private String title;
    private String author;
    private String genre;
    private boolean isBorrowed;

    public Book(String title, String author, String genre, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isBorrowed = isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public java.lang.String toString() {
        return "genre: "+genre+"\n"+
                "Name of the book: "+title+"\n"+
                "Author's name: "+author+"\n"+
                "s borrowed: "+isBorrowed;
}