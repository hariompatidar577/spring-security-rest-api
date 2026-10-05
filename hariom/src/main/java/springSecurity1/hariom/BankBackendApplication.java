package springSecurity1.hariom;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableWebSecurity

//but yha ek hi package me he to zrurt nhi he
//@EntityScan("springSecurity1.hariom")
//@EnableJpaRepositories("sprinSecurity1.hariom")
public class BankBackendApplication {

	public static void main(String[] args){
		SpringApplication.run(BankBackendApplication.class, args);

			}

}
