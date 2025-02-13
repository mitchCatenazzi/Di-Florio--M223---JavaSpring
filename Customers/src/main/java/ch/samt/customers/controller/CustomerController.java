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

        if (userId != null) {
            //nell'url, inserire dopo customers ?id=ID DELL'UTENTE
            for (Customer customer : customers) {
                if (userId.equals(customer.getId())) {
                    model.addAttribute("customers", customer);
                }
            }
        } else {
            model.addAttribute("customers", customers);
        }

        return "customerList";
    }
}
