package ch.samt.carManager.Controller;

import ch.samt.carManager.data.CarRepository;
import ch.samt.carManager.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {

    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public String customerList(Model model, @RequestParam(value = "carmaker", required = false) String carmaker,
                               @RequestParam(value = "color", required = false) String color) {

        if(carmaker != null || color != null)
        {
            if (carmaker != null) {
                List<Car> cars = carRepository.findByBrand(carmaker);
                model.addAttribute("cars", cars);
            }
            if (color != null && carmaker != null) {
                List<Car> cars = carRepository.findByBrandandColor(carmaker,color);
                model.addAttribute("cars", cars);
            }
        }
        else {
            // Se non è stato fornito alcun ID, passiamo l'intera lista dei clienti al modello
            model.addAttribute("cars", carRepository.findAll());
        }


        return "carList";
    }


}
