package com.twu28.biblioteca;
public class Book {
    private boolean reserved;
    private String BookId;
    private String BookName;
    private String BookAuthor;

    public Book(String id, String name, String author){
        this.BookId=id;
        this.BookName=name;
        this.BookAuthor=author;
        this.reserved=false;
    }

    @Override
    public boolean equals(Object otherBook) {
        if (otherBook == null || getClass() != otherBook.getClass()) return false;
        Book book = (Book) otherBook;
        if (BookAuthor != null ? !BookAuthor.equals(book.BookAuthor) : book.BookAuthor != null) return false;
        if (BookId != null ? !BookId.equals(book.BookId) : book.BookId != null) return false;
        return !(BookName != null ? !BookName.equals(book.BookName) : book.BookName != null);
    }

    @Override
    public int hashCode() {
        int result = BookId != null ? BookId.hashCode() : 0;
        result = 31 * result + (BookName != null ? BookName.hashCode() : 0);
        result = 31 * result + (BookAuthor != null ? BookAuthor.hashCode() : 0);
        return result;
    }

    public String Display() {
        StringBuilder book=new StringBuilder();
        book.append("\"").append(this.BookName).append("\"");
        book.append(" -by- ");
        book.append("\"").append(this.BookAuthor).append("\"");
        return book.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookId='" + BookId + '\'' +
                ", BookName='" + BookName + '\'' +
                ", BookAuthor='" + BookAuthor + '\'' +
                '}';
    }

    public String reserveBook() {
        if(this.reserved)
            return "Sorry we don't have that book yet.";
        this.reserved=true;
        return "Thank You! Enjoy the book.";
    }
}
