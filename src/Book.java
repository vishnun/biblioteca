import java.util.ArrayList;

public class Book {
    private String BookId;
    private String BookName;
    private String BookAuthor;

    public static ArrayList<Book> bookList = new ArrayList<Book>();
    static {
        bookList.add(0,new Book("j1","Head First Java", "Kethy Sieria"));
        bookList.add(0,new Book("p1","Let Us C", "Dennis Richie"));
    }

    private Book(String id, String name, String author){
        this.BookId=id;
        this.BookName=name;
        this.BookAuthor=author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (BookAuthor != null ? !BookAuthor.equals(book.BookAuthor) : book.BookAuthor != null) return false;
        if (BookId != null ? !BookId.equals(book.BookId) : book.BookId != null) return false;
        if (BookName != null ? !BookName.equals(book.BookName) : book.BookName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = BookId != null ? BookId.hashCode() : 0;
        result = 31 * result + (BookName != null ? BookName.hashCode() : 0);
        result = 31 * result + (BookAuthor != null ? BookAuthor.hashCode() : 0);
        return result;
    }

    public ArrayList<String> Display() {
        ArrayList<String> book = new ArrayList<String>();
        book.add(this.BookId);
        book.add(this.BookName);
        book.add(this.BookAuthor);
        return book;  //To change body of created methods use File | Settings | File Templates.
    }
}
