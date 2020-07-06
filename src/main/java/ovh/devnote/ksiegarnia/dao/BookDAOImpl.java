package ovh.devnote.ksiegarnia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.ksiegarnia.entity.Book;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Book> getBooks() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> query = currentSession.createQuery("from Book", Book.class);
        List<Book> books = query.getResultList();
        return books;
    }

    @Override
    public List<Book> getBooksByCategoryId(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> query = currentSession.createQuery("from Book where kategoria.id = :id", Book.class)
                .setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void saveBook(Book ksiazka) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(ksiazka);
    }

    @Override
    public Book getBook(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> query = currentSession.createQuery("from Book where id=:id", Book.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void deleteBook(int bookId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("delete from Book where id=:id")
                .setParameter("id", bookId).executeUpdate();
    }

}
