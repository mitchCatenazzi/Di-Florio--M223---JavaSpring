package ch.samt.Customers.controller;

import ch.samt.Customers.data.CustomerRepository;
import ch.samt.Customers.domain.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ch.samt.Customers.data.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("/customers") altra opzione per @PostMapping("/customers/insert")
@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private List<Customer> customers = new ArrayList<>();
    @Value("${server.port}")
    private String port;

    @Value("${ch.samt.envname")
    private String envname;

    @GetMapping("/customers")
    public String index(Model model) {
        model.addAttribute("customer", new Customer());
        return "Home";
    }
    @PostMapping("/customers/insert")
    public String insertCustomer(@ModelAttribute("customer") @Valid Customer customer, Errors errors )  {
        if(errors.hasErrors()) {
            return "Home";
        }
        customers.add(customer);
        customerRepository.save(customer);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String loadCustomers(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if(id != null) {
            for (Customer customer : customers) {
                if (id.equals(customer.getId())) {
                    model.addAttribute("customer", customer);
                }
            }
            return "customer";
        }else{
            model.addAttribute("customers", customerRepository.findAll());
            return "customerList";
        }
    }

    /*@GetMapping("/users/{id}")
    public String getCustomerById(@PathVariable("id") Integer id, Model model) {
        if(id != null) {
            for (Customer customer : customers) {
                if (id.equals(customer.getId())) {
                    model.addAttribute("customer", customer);
                }
            }
        }
        return "customer";
    }*/
    @GetMapping("/users/{surnameToFilter}")
    public String loadInsertPage(@PathVariable("surnameToFilter") String surnameToFilter, Model model) {
        List<Customer> filteredCustomers = customerRepository.findBySurnameIgnoreCase(surnameToFilter);
        model.addAttribute("customer", filteredCustomers);
        return "customer";
    }
    @GetMapping("/appInfo")
    public String Info(Model model) {
        model.addAttribute("envame", envname);
        model.addAttribute("port", port);
        return "Info";
    }
}
