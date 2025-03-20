package ch.samt.Customers.controller;

import ch.samt.Customers.data.CustomerRepository;
import ch.samt.Customers.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


//    private final List<Customer> customers = new ArrayList<Customer>(
//            Arrays.asList(
//                    new Customer(1L,"Maria","Rossi","Rossi@gmail.com", 55),
//                    new Customer(2L,"Giorgia","Verdi", "gianni",30),
//                    new Customer(3L,"Ennio","Bianchi","enniio",33)
//    ));

//    @GetMapping
//    public String loadCustomers(Model model) {
//        model.addAttribute("customers", customerRepository.findAll());
//        return "customerList";
//    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("customer", new Customer());
        return "home";
    }

    @PostMapping("/backHome")
    public String casa(Model model) {
        return "redirect:/";
    }


//    @GetMapping("/users/{id}")
//    public String getUserById(@RequestParam("id") String userId) {
//        return "User ID: " + userId;
//    }

    @PostMapping("/insert")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        //customers.add(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers")
    public String customerList(Model model, @RequestParam(value = "id", required = false) Long userId) {
        // Controlliamo se l'utente ha specificato un ID nella richiesta (ad esempio: /customers?id=1)
        if (userId != null) {
            // Aggiungiamo il cliente corrispondente al modello come attributo "customers"
            model.addAttribute("customers", customerRepository.findById(userId));
        }
        else {
            // Se non è stato fornito alcun ID, passiamo l'intera lista dei clienti al modello
            model.addAttribute("customers", customerRepository.findAll());
        }

        // Restituiamo il nome della vista "customerList" che sarà elaborata da Thymeleaf
        return "customerList";
    }

}
