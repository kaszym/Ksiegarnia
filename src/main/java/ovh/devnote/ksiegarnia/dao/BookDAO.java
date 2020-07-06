package ovh.devnote.ksiegarnia.dao;

import ovh.devnote.ksiegarnia.entity.Book;
import ovh.devnote.ksiegarnia.entity.Category;

import java.util.List;

public interface BookDAO {

    public List<Book> getBooks();

    public List<Book> getBooksByCategoryId(int id);

    public void saveBook(Book ksiazka);

    public Book getBook(int id);

    public void deleteBook(int bookId);
}
