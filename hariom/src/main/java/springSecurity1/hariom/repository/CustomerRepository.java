package springSecurity1.hariom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springSecurity1.hariom.model.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {

    /*
    thats the beauty of the jpa no need to implement whole method just use the right naming jpa do all for you
     */
    //this is method that find the email value and jpa try to find the amil id
    Optional<Customer> findByEmail(String email);

}
