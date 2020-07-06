package ovh.devnote.ksiegarnia.dao;

import ovh.devnote.ksiegarnia.entity.Category;

import java.util.List;

public interface CategoryDAO {

    public Category getCategory(int id);

    public List<Category> getCategories();

    public void saveCategory(Category kategoria);

    public void deleteCategory(int id);

}
