package springSecurity1.hariom.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springSecurity1.hariom.model.Customer;
import springSecurity1.hariom.repository.CustomerRepository;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


    
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){

        try{
            String hashPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashPassword);
          Customer savedCustomer =  customerRepository.save(customer);

          if (savedCustomer.getId() > 0){
              return ResponseEntity.status(HttpStatus.CREATED)
                      .body("user is registered succesfully ");

          }else {
              return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                      .body("User registration faild");
                 }
        } catch (Exception ex) {
           return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("an exception occured " + ex.getMessage());

        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> Login(@RequestBody Customer customer){

        System.out.println( " register this the customer drtails" );
        return registerUser(customer);
//        return null;

    }


}
