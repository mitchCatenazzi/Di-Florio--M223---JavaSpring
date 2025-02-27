package ch.samt.esercizio2product.controller;

import ch.samt.esercizio2product.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {
    private static final Map<Integer, Product> products = new HashMap<>();

    static {
        Product zelda = new Product(1,"zelda",BigDecimal.valueOf(20.0),LocalDate.parse("2006-05-10"));
        products.put(zelda.getId(),zelda);
        Product packman = new Product(2,"packman",BigDecimal.valueOf(40.0),LocalDate.parse("2025-06-10"));
        products.put(packman.getId(), packman);
        Product ageOfEmpries = new Product(3,"age of empries",BigDecimal.valueOf(60.0),LocalDate.parse("2026-07-10"));
        products.put(ageOfEmpries.getId(),ageOfEmpries);
        Product spaceInvaders = new Product(4,"space invaders",BigDecimal.valueOf(80.0),LocalDate.parse("2027-08-10"));
        products.put(spaceInvaders.getId(), spaceInvaders);
    }

    @GetMapping("/products")
    public String newProductList(Model model){
            for (Product Product : products.values()) {
                model.addAttribute("Product", products.values());
            }
        return "ProductList";
    }

}
