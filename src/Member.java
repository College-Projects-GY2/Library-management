public class Member {
    private String id;
    private String username;
    private String password;
    private boolean isPremium;
    private Book[] borrowedBooks;
    private int borrowedCount;

    public Member(String id, String user, String pass, boolean premium){
        this.id = id;
        this.username = user;
        this.password = pass;
        this.isPremium = premium;
        borrowedCount = 0;
        if(isPremium)
            borrowedBooks = new Book[10];
        else
            borrowedBooks = new Book[3];
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
        return isPremium;
    }

    public Book[] getBorrowedBooks(){
        if(borrowedCount==borrowedBooks.length)
            return borrowedBooks;
        if (borrowedCount==0)
            return new Book[0];
        Book[] books = new Book[borrowedCount];
        for(int i = 0 ; i < books.length ; i++)
            books[i] = borrowedBooks[i];
        return books;
    }

    public int getBorrowedCount(){
        return  borrowedCount;
    }

    public boolean borrowBook(Book book){
        if(borrowedCount == borrowedBooks.length)
            return false;

        borrowedBooks[borrowedCount] = book;
        borrowedCount++;
        return true;
    }

    public boolean returnBook(Book book){
        if (borrowedCount==0)
            return false;
        boolean flag = false;
        for(int  i = 0 ; i < borrowedCount ; i++)
            if(book == borrowedBooks[i]){
                borrowedBooks[i] = null;
                flag = true;
                borrowedCount --;
                break;
            }
        if(!flag)
            return false;
        for(int i = 0 ; i < borrowedCount ; i ++)
            if(borrowedBooks[i] == null)
                borrowedBooks[i] = borrowedBooks[i + 1];
        return flag;
    }
}