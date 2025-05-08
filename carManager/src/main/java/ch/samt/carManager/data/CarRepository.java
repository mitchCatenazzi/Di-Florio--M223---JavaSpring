package ch.samt.carManager.data;

import ch.samt.carManager.domain.Car;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Query("SELECT * FROM Car WHERE carMaker = (:brand)")
    List<Car> findByBrand(String brand);


    @Query("SELECT * FROM Car WHERE carMaker = (:brand) AND color = (:color)")
    List<Car> findByBrandandColor(String brand, String color);

}
