package ch.samt.customers.controller;

import ch.samt.customers.data.CustomerGroupRepository;
import ch.samt.customers.data.CustomerRepository;
import ch.samt.customers.data.ReservationRepository;
import ch.samt.customers.domain.Customer;
import ch.samt.customers.domain.Reservation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@Controller
public class CustomerController {

    private CustomerRepository customerRepository;
    private ReservationRepository reservationRepository;
    private CustomerGroupRepository customerGroupRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, ReservationRepository reservationRepository, CustomerGroupRepository customerGroupRepository) {
        this.customerRepository = customerRepository;
        this.reservationRepository = reservationRepository;
        this.customerGroupRepository = customerGroupRepository;
    }

//    private final List<Customer> customers = new ArrayList<>(
//            Arrays.asList(
//                    new Customer(1L, "Maria", "Rossi", 40),
//                    new Customer(2L, "Giorgia", "Verdi", 30),
//                    new Customer(3L, "Ennio", "Bianchi", 33)
//            ));

    @GetMapping
    public String loadCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customerList";
    }

    @GetMapping("/reservation")
    public String loadReservations(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservationList";
    }

    @GetMapping("/customer-groups")
    public String loadCustomerGroups(Model model) {
        model.addAttribute("customerGroups", customerGroupRepository.findAll());
        return "customerGroupList";
    }

    @GetMapping("/insert")
    public String loadInsertPage(@ModelAttribute Customer customer) {
        return "insertCustomer";
    }

    @PostMapping("/insert")
    public String saveCustomers(@Valid Customer customer, Errors errors) {
        if (errors.hasErrors()) {
            return "insertCustomer";
        }

        // customers.add(customer);
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    // Per modifica
    @GetMapping("/edit/{customerId}")
    public String loadEditPage(@ModelAttribute Customer customer, Model model, @PathVariable long customerId) {
        model.addAttribute("customer", customerRepository.findById(customerId).get());
        return "insertCustomer";
    }

    @PostMapping("/edit/{customer}")
    public String updateCustomers(@Valid Customer customer, Errors errors) {
        if(errors.hasErrors()) {
            return "insertCustomer";
        }
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{surnameToFilter}")
    public String loadInsertPage(Model model, @PathVariable String surnameToFilter) {

        // List<Customer> filteredCustomers = customers.stream()
        // .filter(customer -> customer.getSurname().equalsIgnoreCase(surnameToFilter)).toList();
        List<Customer> filteredCustomers = customerRepository.findBySurname(surnameToFilter);

        model.addAttribute("customers", filteredCustomers);
        return "customerList";
    }

}