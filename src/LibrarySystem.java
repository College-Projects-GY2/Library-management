import java.util.Scanner;

public class LibrarySystem {
    private Library library = new Library();
    private Scanner scanner = new Scanner(System.in);

    public void showMemberMenu(Member member){
        while (true){
            printMenuOfMember();
            int num=scanner.nextInt();
            switch (num){
                case 1:
                    borrowBookMember(member);
                    break;
                case 2:
                    returnBookMember(member);
                    break;
                case 3:
                    if (member.getBorrowedCount()==0)
                        System.out.println("\nNo books borrowed\n");
                    else
                        printBooks(member.getBorrowedBooks());
                    break;
                case 4:
                    printBooksByGenre(library.getBooks());
                    break;
                case 5:
                    String str="";
                    System.out.print("please enter title or genre: ");
                    str= scanner.next();
                    printBookFindByGenreOrTitle(library.getBooks(),str);
                    break;
                default:
                    return;
            }
        }
    }
    public void printMenuOfMember(){
        System.out.println("*** Member Menu ***");
        System.out.println("------------------");
        System.out.println("1. Borrow a Book");
        System.out.println("2. Return a Book");
        System.out.println("3. View My Borrowed Books");
        System.out.println("4. View All Books (By Genre)");
        System.out.println("5. Search for a Book (By Title/Genre)");
        System.out.println("Press other number to Log Out");
        System.out.print("Please enter your choice: ");
    }
    public void printBooks(Book[]books){
        System.out.println("\n\n    *** books ****");
        System.out.println("-----------------------");
        for (int i=0;i<books.length;i++){
            System.out.println("num: "+(i+1));
            System.out.println(books[i]);
            System.out.println("------------------");
        }
        System.out.println("\n");
    }
    public void borrowBookMember(Member member){
        if (member.isPremium()&&member.getBorrowedCount()==10)
            System.out.println("\nYou have reached 10 books. You cannot borrow any more books.\n");
        else if (member.getBorrowedCount()==3){
            System.out.println("\nYou have reached 3 books. You cannot borrow any more books.\n");
            return;
        }
        Book[]books=library.getBooks();
        printBooks(books);
        System.out.print("\nplease chose book: ");
        int temp=scanner.nextInt();
        if (temp>books.length||temp<=0)
            System.out.println("\nError: Number outside the rules\n");
        else if (books[temp-1].isBorrowed())
            System.out.println("\nError: Book borrowed\n");
        else{
            member.borrowBook(books[temp-1]);
            books[temp-1].setBorrowed(true);
            System.out.println("\nThe book was successfully borrowed.\n");
        }
    }
    public void returnBookMember(Member member){
        if (member.getBorrowedCount()==0){
            System.out.println("\nError: No books borrowed\n");
            return;
        }
        printBooks(member.getBorrowedBooks());
        System.out.print("\nplease chose book: ");
        int temp=scanner.nextInt();
        if (temp>member.getBorrowedCount()||temp<=0){
            System.out.println("\nError: Number outside the rules\n");
            return;
        }
        member.getBorrowedBooks()[temp-1].setBorrowed(false);
        member.returnBook(member.getBorrowedBooks()[temp-1]);
        System.out.println("\nThe book was successfully returned to the library.\n");
    }
    public String[] unique(String[]strings){
        int temp= strings.length;
        for (int i=0;i<strings.length;i++)
            for (int k=i+1;k< strings.length;k++)
                if (strings[i]!=null&&strings[k]!=null&&strings[i].equals(strings[k])){
                    strings[k]=null;
                    temp--;
                }
        String []unique=new String[temp];
        int index=0;
        for(String i:strings)
            if (i!=null){
                unique[index]=i;
                index++;
            }
        return unique;
    }
    public void printBooksByGenre(Book[]books){
        String []genres=new String[books.length];
        for(int i=0;i< books.length;i++){
            genres[i]=books[i].getGenre();
        }
        genres=unique(genres);
        for(String i:genres){
            System.out.println("\n\ngenre: "+i);
            System.out.println("-----------------");
            int num=1;
            for(Book k:books){
                if (k.getGenre().equals(i)){
                    System.out.println("num: "+num);
                    System.out.println(k);
                    System.out.println("-----");
                    num++;
                }
            }
        }
        System.out.println("\n");
    }
    public void printBookFindByGenreOrTitle(Book[]books,String str){
        int count=0;
        for (Book i:books)
            if (i.getTitle().equals(str)||i.getGenre().equals(str))
                count++;
        if (count==0){
            System.out.println("\nno book with title or genre "+str+"\n");
            return;
        }
        System.out.println("\n\n    *** books ****");
        System.out.println("-----------------------");
        for(int i=0;i<books.length;i++)
            if (books[i].getGenre().equals(str)||books[i].getTitle().equals(str)){
                System.out.println("num: "+(i+1));
                System.out.println(books[i]);
                System.out.println("------------------");
            }
        System.out.println("\n");
    }
}
