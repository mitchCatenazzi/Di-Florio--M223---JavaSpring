package ch.samt.esercizio1.controller;

import ch.samt.esercizio1.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    //List<User> users = new ArrayList<User>();
    private final Map<Integer, User> users = new HashMap<>();

    // sotto resources/application.properties inserire porta, nel nostro caso la 8088
    // server.port=8088
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/{name}")
    public String HelloName(Model model, @PathVariable(value = "name", required = false) String name) {
        model.addAttribute("name", name);
        return "home";
    }




    @GetMapping("/user/insert")
    public String addName(Model model) {
        //model.addAttribute("user", new User());

        //model.addAttribute("users", users);
        //users.put(user.getId(),user);
        model.addAttribute("user", new User());
        model.addAttribute("users", users);
        return "addName";

    }

    //l'endpoint può chiamarsi nello stesso modo i un altro, a patto che uno sia POST e uno GET
    @PostMapping("/user/insert")
    public String saveUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "redirect:/user/insert";
    }


    @GetMapping("/user/load")
    public String UserName(Model model, @RequestParam(value = "userId", required = false) Integer userId) {

        if (userId != null) {
            //nell'url, inserire dopo customers ?id=ID DELL'UTENTE
            for (User customer : users.values()) {
                if (userId.equals(customer.getId())) {
                    model.addAttribute("user", users);
                }
            }
        } else {
            model.addAttribute("user", users);
        }

        return "addName";

    }





}
