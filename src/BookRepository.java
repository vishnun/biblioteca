import java.util.ArrayList;
public class BookRepository {
    public static ArrayList<Book> BookList=new ArrayList<Book>();
    static {
        BookList.add(0, new Book("j1", "Head First Java", "Kethy Sieria"));
        BookList.add(0, new Book("p1", "Let Us C", "Dennis Richie"));
    }

    public ArrayList<String> DisplayAllBooks(){
        ArrayList<String> books=new ArrayList<String>();
        int index=1;
        for(Book book:BookList){
            books.add(""+ index++ +" " +book.Display());
        }
        return books;
    }
    public Book GetBook(int SrNo){
        if(SrNo>0 && SrNo<= BookList.size()) return BookList.get(SrNo-1);
        throw new RuntimeException("Sorry we don't have that book yet.");
    }
}
