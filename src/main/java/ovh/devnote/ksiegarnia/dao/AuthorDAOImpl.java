package ovh.devnote.ksiegarnia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.ksiegarnia.entity.Author;
import ovh.devnote.ksiegarnia.entity.Category;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{

    @Autowired
    SessionFactory sessionFactory;

    public AuthorDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Author getAuthor(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Author> query = currentSession.createQuery("from Author where id=:id", Author.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Author> getAuthors() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Author> query = currentSession.createQuery("from Author", Author.class);
        return query.getResultList();
    }

    @Override
    public void saveAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(author);
    }

    @Override
    public void deleteAuthor(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("delete from Author where id=:id")
                .setParameter("id", id).executeUpdate();
    }
}