package springSecurity1.hariom.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @GetMapping("/myAccount")
    public String getAccountDetails(){
        return "here is the account details of db";
    }
}
