package ch.samt.libraryManager.controller;

import ch.samt.libraryManager.service.BookService;
import ch.samt.libraryManager.service.MYUserService;
import ch.samt.libraryManager.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/books")
@Controller
public class libraryManagerController {

    private MYUserService myUserService;
    private BookService bookService;
    private ReservationService reservationService;

    @Autowired
    public libraryManagerController(MYUserService myUserService, BookService bookService, ReservationService reservationService) {
        this.myUserService = myUserService;
        this.bookService = bookService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public String books(Model model) {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "BookList";
    }

    @PostMapping("/seeStatus")
    public String seeStatus(@RequestParam Long bookId, Model model) {
        BookService.BookDetails details = bookService.getBookDetails(bookId);
        if (details == null) {
            model.addAttribute("errorMessage", "Book not found.");
            return "error";
        }

        model.addAttribute("book", details.getBook());
        model.addAttribute("reservation", details.getReservation());
        model.addAttribute("user", details.getUser());

        return "BookStatus";
    }


}
