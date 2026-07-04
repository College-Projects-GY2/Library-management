public class Library {
    private Book[]book;
    private int bookCount;
    private Member[] members;
    private int memberCount;
    private Admin admin;
    public Library() {
        this.book = new Book[100];
        this.bookCount = 0;
        this.members = new Member[50];
        this.memberCount = 0;
        this.admin = new Admin("admin", "admin123");
        creatingTenBooks();
    }

    private void creatingTenBooks() {
        for (int i = 0; i < 10; i++) {
            this.book[this.bookCount] = new Book("Book " + (i + 1), "Author " + (i + 1), "General");
            this.bookCount++;
        }
    }

    public boolean registerMember(String id, String user, String pass, boolean premium) {
        if (this.memberCount >= 50) {
            return false;
        }

        for (int i = 0; i < this.memberCount; i++) {
            if (this.members[i].getId().equals(id)) {
                return false;
            }
        }

        this.members[this.memberCount] = new Member(id, user, pass, premium);
        this.memberCount++;
        return true;
    }
    public Object login(String idOrUser, String password) {
        if (this.admin.getUsername().equals(idOrUser) && this.admin.getPassword().equals(password)) {
            return this.admin;
        }

        for (int i = 0; i < this.memberCount; i++) {
            if (this.members[i].getId().equals(idOrUser) && this.members[i].getPassword().equals(password)) {
                return this.members[i];
            }
        }

        return null;
    }
    public boolean addBook(String title, String author, String genre){
        if (this.bookCount >= 100) {
            return false;
        }

        this.book[this.bookCount] = new Book(title, author, genre);
        this.bookCount++;
        return true;
    }
    public boolean removeBook(String title, String author, String genre) {
        int targetIndex = -1;

        for (int i = 0; i < this.bookCount; i++) {
            if (this.book[i].getTitle().equals(title) && this.book[i].getAuthor().equals(author) && this.book[i].getGenre().equals(genre)) {
                targetIndex = i;
                break;
            }
        }
        if (targetIndex == -1) {
            return false;
        }

        for (int i = targetIndex; i < this.bookCount - 1; i++) {
            this.book[i] = this.book[i + 1];
        }
        this.book[this.bookCount - 1] = null;
        this.bookCount--;
        return true;
    }

}