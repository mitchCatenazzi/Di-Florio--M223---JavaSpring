package ch.sam.Book.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BookListController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("book", new Book());
        return "home";
    }


    @GetMapping("/insert")
    public String saveBook(@ModelAttribute Book book){
        System.out.println(book);
        return "bookAdded";
    }

}