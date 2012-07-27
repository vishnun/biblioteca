package com.twu28.biblioteca;
import java.util.ArrayList;
public class BookRepository {
    private ArrayList<Book> BookList=new ArrayList<Book>();

    public BookRepository(){
        this.initializeBookList();
    }

    public ArrayList<String> displayAllBooks(){
        ArrayList<String> books=new ArrayList<String>();
        int index=1;
        for(Book book:BookList){
            books.add(""+ index++ +" " +book.display());
        }
        return books;
    }
    public Book getBook(int SrNo){
        Integer index=SrNo-1;
        if(bookExists(index)) return BookList.get(index);
        throw new RuntimeException("Sorry we don't have that book yet.");
    }

    private boolean bookExists(Integer index) {
        return index>=0 && index< BookList.size();
    }

    public String reserveBook(int SrNo) {
        Book book;
        book= getBook(SrNo);
        return book.reserveBook();
    }

    private void initializeBookList() {
        BookList.removeAll(BookList);
        BookList.add(0, new Book("c1", "Harry Potter", "J K Rowling"));
        BookList.add(0, new Book("j1", "Head First Java", "Kethy Sieria"));
        BookList.add(0, new Book("p1", "Let Us C", "Dennis Richie"));
    }
}
