package ovh.devnote.ksiegarnia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.ksiegarnia.entity.Category;

import java.util.List;
@Repository
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    SessionFactory sessionFactory;

    public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Category getCategory(int categoryId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Category> query = currentSession.createQuery("from Category where id=:id", Category.class)
                .setParameter("id", categoryId);
        return query.getSingleResult();
    }

    @Override
    public List<Category> getCategories() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Category> query = currentSession.createQuery("from Category", Category.class);
        return query.getResultList();
    }

    @Override
    public void saveCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("update Book set kategoria=null where kategoria.id=:id")
                .setParameter("id", categoryId).executeUpdate();
        currentSession.createQuery("delete from Category where id=:id")
                .setParameter("id", categoryId).executeUpdate();
    }
}
