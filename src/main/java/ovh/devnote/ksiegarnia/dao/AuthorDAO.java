package ovh.devnote.ksiegarnia.dao;

import ovh.devnote.ksiegarnia.entity.Author;
import ovh.devnote.ksiegarnia.entity.Category;

import java.util.List;

public interface AuthorDAO {

    public Author getAuthor(int id);

    public List<Author> getAuthors();

    public void saveAuthor(Author author);

    public void deleteAuthor(int id);

}
