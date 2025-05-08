package ch.samt.blog.controller;

import ch.samt.blog.data.BlogRepository;
import ch.samt.blog.domain.Blog;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/blog")
    public String loadBlog(Model model, @RequestParam(value = "postid", required = false) Integer postid) {
        if (postid != null) {
                model.addAttribute("blog", blogRepository.findById(postid).get());
        }
        else{
            model.addAttribute("blogs", blogRepository.findAll());
            return "BlogView";
        }
        return "blogView";
    }


    @PostMapping("/blog/new")
    public String openInsert(Model model) {
        model.addAttribute("blog", new Blog());
        return "addBlog";
    }

    @PostMapping("/insert")
    public String saveBlog(@Valid @ModelAttribute("blog") Blog blog, BindingResult bindingResult, Model model) {
        // Salvataggio del blog
        blogRepository.save(blog);
        // Reindirizza alla lista dei blog (oppure a una pagina di conferma)
        return "redirect:/blog";
    }
}
