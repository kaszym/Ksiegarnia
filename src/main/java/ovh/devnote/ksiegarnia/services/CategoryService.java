package ovh.devnote.ksiegarnia.services;

import ovh.devnote.ksiegarnia.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getCategories();
    public void saveCategory(Category category);
    public Category getCategory(int categoryId);
    public void deleteCategory(int categoryId);
}
