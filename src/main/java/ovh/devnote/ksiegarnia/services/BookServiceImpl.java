package ovh.devnote.ksiegarnia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ovh.devnote.ksiegarnia.entity.Book;
import ovh.devnote.ksiegarnia.dao.BookDAO;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Transactional
    @Override
    public List<Book> getBooks() {
        List<Book> books = bookDAO.getBooks();
        return books;
    }

    @Transactional
    @Override
    public List<Book> getBooksByCategoryId(int id) {
        return bookDAO.getBooksByCategoryId(id);
    }

    @Transactional
    @Override
    public void saveBook(Book ksiazka) {
        bookDAO.saveBook(ksiazka);
    }

    @Override
    @Transactional
    public Book getBook(int bookId) {
        return bookDAO.getBook(bookId);
    }

    @Override
    @Transactional
    public void deleteBook(int bookId) {
        bookDAO.deleteBook(bookId);
    }

}
