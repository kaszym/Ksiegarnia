package ovh.devnote.ksiegarnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.ksiegarnia.entity.Author;
import ovh.devnote.ksiegarnia.services.AuthorService;
import ovh.devnote.ksiegarnia.services.BookService;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    @Autowired
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @GetMapping("/list")
    public  String listAutors(Model model){
        List<Author> authors= authorService.getAuthors();
        model.addAttribute("authors", authors);
        return "authorslist";
    }

    @GetMapping("/admin/list")
    public  String listAdminAutors(Model model){
        List<Author> authors= authorService.getAuthors();
        model.addAttribute("authors", authors);
        return "authorsadminlist";
    }


    @GetMapping("/admin/formadd")
    public String addForm(Model model) {
        Author author= new Author();
        model.addAttribute("author", author);
        return "addauthorform";
    }

    @PostMapping("/admin/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors/admin/list";
    }

    @GetMapping("/admin/updateAuthorForm")
    public String updateAuthorForm(@RequestParam("authorId") int authorId, Model model) {
        model.addAttribute("author", authorService.getAuthor(authorId));
        return "addauthorform";
    }


    @GetMapping("/admin/deleteAuthorForm")
    public  String deleteAuthor(@RequestParam("authorId") int authorId){
        authorService.deleteAuthor(authorId);

        return  "redirect:/authors/admin/list";
    }
}
