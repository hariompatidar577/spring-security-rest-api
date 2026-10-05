package springSecurity1.hariom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    //agr table namr or entity name different ho to uske upr mention kr skte e name
//@Column(name = "password")
    private String password;
    private String role;
}
