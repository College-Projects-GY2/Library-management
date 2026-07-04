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

}