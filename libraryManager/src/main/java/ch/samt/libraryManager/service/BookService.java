package ch.samt.libraryManager.service;

import ch.samt.libraryManager.domain.Book;
import ch.samt.libraryManager.domain.MyUser;
import ch.samt.libraryManager.domain.Reservation;
import ch.samt.libraryManager.data.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final ReservationService reservationService;
    private final MYUserService myUserService;


    @Autowired
    public BookService(BookRepository bookRepository, ReservationService reservationService, MYUserService myUserService) {
        this.bookRepository = bookRepository;
        this.reservationService = reservationService;
        this.myUserService = myUserService;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    public BookDetails getBookDetails(Long bookId) {
        Book book = getBookById(bookId);
        if (book == null) {
            return null;
        }

        List<Reservation> reservations = reservationService.getReservationsByBookId(bookId);

        MyUser user = null;
        Reservation reservation = null;
        if (!reservations.isEmpty()) {
            reservation = reservations.get(0);
            user = reservation.getMYUser();
        }

        return new BookDetails(book, reservation, user);
    }


    public static class BookDetails {
        private Book book;
        private Reservation reservation;
        private MyUser user;

        public BookDetails(Book book, Reservation reservation, MyUser user) {
            this.book = book;
            this.reservation = reservation;
            this.user = user;
        }

        // getters
        public Book getBook() { return book; }
        public Reservation getReservation() { return reservation; }
        public MyUser getUser() { return user; }
    }
}
