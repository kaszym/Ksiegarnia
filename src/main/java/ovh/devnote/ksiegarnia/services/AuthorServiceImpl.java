package ovh.devnote.ksiegarnia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.devnote.ksiegarnia.dao.AuthorDAO;
import ovh.devnote.ksiegarnia.entity.Author;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Transactional
    @Override
    public void deleteAuthor(int id) {
        authorDAO.deleteAuthor(id);

    }
    @Transactional
    @Override
    public Author getAuthor(int id) {
        return authorDAO.getAuthor(id);
    }

    @Override
    @Transactional
    public List<Author> getAuthors() {
        List<Author> authors = authorDAO.getAuthors();
        return authors;
    }

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        authorDAO.saveAuthor(author);
    }

}
