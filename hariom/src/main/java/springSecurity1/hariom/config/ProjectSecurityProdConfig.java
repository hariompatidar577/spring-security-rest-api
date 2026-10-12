package springSecurity1.hariom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("prod")
public class ProjectSecurityProdConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) -> ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).denyAll());
//        http.authorizeHttpRequests((requests) -> ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).permitAll());

        http
                .redirectToHttps(Customizer.withDefaults())
                .csrf(csrfConfig -> csrfConfig.disable()); // csrf token ko disable kiya he

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/myBalance" , "/myCards" , "/myLoans" , "/myAccount").authenticated()
                .requestMatchers(  "/notices", "/contact", "/error" ,"/register").permitAll());
//        .requests.requestMatchers("/myAccount" , "/notices", "/contact", "/error ").denyAll());
//       http.formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable());
       http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

/*
noop = this is considers as a no secured password this paswors is not secured by tthe outsider and seen by everyone
bycrpt = this is the encrpted password which is secured by the bycrypter and no one can revere the password it is completely secured

 */
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//
//        //bcryptedpassword
////       UserDetails user= User.withUsername("hariom")
////               .password("{bcrypt}$2a$12$h3Y3C1FOv9JuvpPzpMcF6.Eo1MP4YgHXBKwkai7CKnkrd/a.uvE7K")
////               .authorities("read")
////               .build();
////
////       //this is hardcoded password which is not good
//////       UserDetails user= User.withUsername("user").password("{noop}12345").authorities("read").build();
////       UserDetails admin= User.withUsername("admin")
////               .password("{bcrypt}$2a$12$OkSJS1xjU59ZECRKW5HB7OFAuclyf8MZ54AN5uOZMGzv.EGsrnm8.")
////               .authorities("admin")
////               .build();
//
//       //not good
////       UserDetails admin= User.withUsername("admin").password("{noop}123456").authorities("admin").build();
////        return new InMemoryUserDetailsManager(user , admin);
//
//        //itna sb ki jgh ab ye kaam kregi bs
//        return new JdbcUserDetailsManager(dataSource); //yha hm jdbc ki inbuillt method ka use kr rhe he  ab sara password detail database se load krenge and chek krenge
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
                      // ye password ko hash me convert kr ke database me store kr ra he
//        return new BCryptPasswordEncoder(); this it also type of the passwordencodeer factories
        return  PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }
//
//    @Bean
//    public CompromisedPasswordChecker compromisedPasswordChecker(){
//         //ye ek organigation he jo password copromised ho chuke he unka suggetion deti he
//        //ye pr build method e
//      return new  HaveIBeenPwnedRestApiPasswordChecker();
//
////        return  new CompromisedPasswordChecker() {
////            @Override
////            public CompromisedPasswordDecision check(@Nullable String password) {
////                return null;
////            }
////        }
//    }

    

}
