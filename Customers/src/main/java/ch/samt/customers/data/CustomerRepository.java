package ch.samt.Customers.data;

import ch.samt.Customers.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //@Query("SELECT * FROM customer WHERE LOWER(surname) = LOWER(:surname)")
    List<Customer> findBySurnameIgnoreCase(String surname);
}
