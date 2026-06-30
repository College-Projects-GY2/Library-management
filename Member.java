public class Member {
    private String id;
    private String username;
    private String password;
    private boolean isPremium;
    private Book[] borrowedBooks;
    private int borrowedCount;


    public Member(boolean isPremium) {
        this.isPremium = isPremium;
        this.borrowedCount = 0;

        if (isPremium) {
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

    public Book[] getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public int getBorrowedCount() {
        return this.borrowedCount;
    }

    public boolean borrowBook(Book book) {
        if (this.borrowedCount >= this.borrowedBooks.length) {
            return false;
        }
        this.borrowedBooks[this.borrowedCount] = book;
        this.borrowedCount++;
        return true;
    }

    public boolean returnBook(Book book) {
        for (int i = 0; i < this.borrowedCount; i++) {
            if (this.borrowedBooks[i].equals(book)) {

                for (int j = i; j < this.borrowedCount - 1; j++) {
                    this.borrowedBooks[j] = this.borrowedBooks[j + 1];
                }

                this.borrowedBooks[this.borrowedCount - 1] = null;
                this.borrowedCount--;

                return true;
            }
        }
        return false;
    }
}