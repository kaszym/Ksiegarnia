package ovh.devnote.ksiegarnia.services;

import ovh.devnote.ksiegarnia.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> getBooks();
    public List<Book> getBooksByCategoryId(int id);
    public void saveBook(Book ksiazka);
    public Book getBook(int id);
    public void deleteBook(int id);
}
