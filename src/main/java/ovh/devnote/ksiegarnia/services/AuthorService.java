package ovh.devnote.ksiegarnia.services;

import ovh.devnote.ksiegarnia.entity.Author;

import java.util.List;

public interface AuthorService {

    public void deleteAuthor(int id);
    public Author getAuthor(int id);
    public List<Author> getAuthors();
    public  void saveAuthor(Author autor);
}
