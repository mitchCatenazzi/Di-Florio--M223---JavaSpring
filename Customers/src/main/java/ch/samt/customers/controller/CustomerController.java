package ch.samt.Customers.controller;

import ch.samt.Customers.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CustomerController {

    List<Customer> customers = new ArrayList<Customer>();

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
        customers.add(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers")
    public String customerList(Model model, @RequestParam(value = "id", required = false) Long userId) {
        // Controlliamo se l'utente ha specificato un ID nella richiesta (ad esempio: /customers?id=1)
        if (userId != null) {
            // Iteriamo la lista di tutti i clienti per trovare quello con l'ID corrispondente
            for (Customer customer : customers) {
                // Se l'ID dell'utente corrisponde a quello del cliente
                if (userId.equals(customer.getId())) {
                    // Aggiungiamo il cliente corrispondente al modello come attributo "customers"
                    model.addAttribute("customers", customer);
                }
            }
        } else {
            // Se non è stato fornito alcun ID, passiamo l'intera lista dei clienti al modello
            model.addAttribute("customers", customers);
        }

        // Restituiamo il nome della vista "customerList" che sarà elaborata da Thymeleaf
        return "customerList";
    }

}
