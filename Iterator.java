import java.util.ArrayList;
import java.util.List;

public class Iterator {
    public static void main(String[] args) {
        LibraryBook book1=new LibraryBook("1", "Java");
        LibraryBook book2=new LibraryBook("2", "C");
        LibraryBook book3=new LibraryBook("3", "C++");
        LibraryBook book4=new LibraryBook("4", "JavaScript");
        LibraryBook book5=new LibraryBook("5", "Python");
        ILibrary library=new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        IBookIterator iterator=library.getIterator();
        while(iterator.isLastBook()){
            System.out.println(iterator.nextBook());
        }

        System.out.println("After Removing book 3:");
        library.removeBook(book3);

        while(iterator.isLastBook()){
            System.out.println(iterator.nextBook());
        }

    }
}

class LibraryBook{
    private String BookId;
    private String BookName;
    public LibraryBook(String bookId, String bookName) {
        BookId = bookId;
        BookName = bookName;
    }
    public String getBookId() {
        return BookId;
    }
    public String getBookName() {
        return BookName;
    }
    @Override
    public String toString() {
        return "LibraryBook [BookId=" + BookId + ", BookName=" + BookName + "]";
    }

    
}

interface ILibrary{
    public void addBook(LibraryBook book);
    public void removeBook(LibraryBook book);
    public BookIterator getIterator();

}

class Library implements ILibrary{
    List<LibraryBook> books;
   // private int index=-1;
    public Library(){
        books=new ArrayList<>();
    }
    @Override
    public void addBook(LibraryBook book) {
        books.add(book);
      //  index++;
    }

    @Override
    public void removeBook(LibraryBook book) {
        books.remove(book);
    }

    @Override
    public BookIterator getIterator() {
        return new BookIterator(this.books);
    }

}

interface IBookIterator{
    public LibraryBook nextBook();
    public boolean isLastBook();
}

class BookIterator implements IBookIterator{
    private List<LibraryBook> books;
    private int index=0;
    public BookIterator(List<LibraryBook> books){
        this.books=books;
    }
    @Override
    public LibraryBook nextBook() {
       // System.out.println("Returning the book: ");
        return books.get(index++);
    }
    @Override
    public boolean isLastBook() {
        if(index>=books.size()){
        index=0;
        return false;
        }
        return true;
    }

}
