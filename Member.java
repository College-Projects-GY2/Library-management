public class Member {
    private String id;
    private String username;
    private String password;
    private boolean isPremium;
    private []book borrowedBooks;
    private int borrowedCount;


    public Member(boolean isPremium) {
        this.isPremium = isPremium;

        if (isPremium == true) {
            this.borrowedBooks = new Book[10];
        } else {
            this.borrowedBooks = new Book[3];
        }
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isPremium() {
        return this.isPremium;
    }

    public book getBorrowedBooks() {
        return borrowedBooks;
    }

    public Book[] getBorrowedBooks() {
        return this.borrowedBooks;
    }
}