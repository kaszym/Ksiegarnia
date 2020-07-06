package ovh.devnote.ksiegarnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.ksiegarnia.entity.Book;
import ovh.devnote.ksiegarnia.entity.Category;
import ovh.devnote.ksiegarnia.services.AuthorService;
import ovh.devnote.ksiegarnia.services.BookService;
import ovh.devnote.ksiegarnia.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    private final CategoryService categoryService;

    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService, AuthorService authorService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public String listBooks(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books",books);
        model.addAttribute("c", new Category());
        model.addAttribute("categories", categoryService.getCategories());
        System.out.println("-----------");
        return "bookslist";
    }

    @GetMapping("/list/byCategory")
    public String listBooksByCategory(@RequestParam("category") Category category, Model model) {

        System.out.println("-------------"+category.getId());
        category.setId(4);
        System.out.println("-------------"+category.getId());
        List<Book> books = bookService.getBooksByCategoryId(category.getId());
        for (Book book: books){
            System.out.println("----------------" + book.toString());
        }
        model.addAttribute("books", books);
        return "bookslistbycategory";
    }

    @GetMapping("/admin/list")
    public String listAdminBooks(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books",books);
        return "booksadminlist";
    }

    @GetMapping("/admin/formadd")
    public String addForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("authors", authorService.getAuthors());
        return "addbookform";
    }

    @PostMapping("/admin/saveBook")
    public String saveBook(@ModelAttribute("book") Book ksiazka) {
        System.out.println("---------------"+ ksiazka.getAutorzy().toString() + "------------------");
        bookService.saveBook(ksiazka);
        System.out.println("---------------"+ ksiazka.getAutorzy().toString() + "------------------");
        return "redirect:/books/admin/list";
    }

    @GetMapping("/admin/updateBookForm")
    public String updateBookForm(@RequestParam("bookId") int bookId, Model model) {
        System.out.println("-----------------" + authorService.getAuthors().toString() + "----------------------------");
        model.addAttribute("book", bookService.getBook(bookId));
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("authors", authorService.getAuthors());
        System.out.println("-----------------" + authorService.getAuthors().toString() + "----------------------------");
        return "addbookform";
    }

    @GetMapping("/admin/deleteBookForm")
    public String deleteBook(@RequestParam("bookId") int bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books/admin/list";
    }


}