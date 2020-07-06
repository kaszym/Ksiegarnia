package ovh.devnote.ksiegarnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.ksiegarnia.entity.Category;
import ovh.devnote.ksiegarnia.services.CategoryService;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/list")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "categorieslist";
    }

    @GetMapping("/admin/list")
    public String listAdminCategories(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "categoriesadminlist";
    }

    @GetMapping("/admin/formadd")
    public String addForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategoryform";
    }

    @PostMapping("/admin/saveCategory")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories/admin/list";
    }

    @GetMapping("/admin/updateCategoryForm")
    public String updateCategoryForm(@RequestParam("categoryId") int categoryId, Model model) {
        model.addAttribute("category", categoryService.getCategory(categoryId));
        return "addcategoryform";
    }

    @GetMapping("/admin/deleteCategoryForm")
    public String deleteCategory(@RequestParam("categoryId") int categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/categories/admin/list";
    }


}
