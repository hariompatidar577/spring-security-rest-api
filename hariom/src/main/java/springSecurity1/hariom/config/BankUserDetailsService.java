package springSecurity1.hariom.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springSecurity1.hariom.model.Customer;
import springSecurity1.hariom.repository.CustomerRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public  class BankUserDetailsService implements UserDetailsService {


    private final CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer= customerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found" + username));

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));
  return new User(customer.getEmail(),customer.getPassword() , authorities);
    }
}
