package springSecurity1.hariom.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod") // ye profile prod ke alawa sb jgh khulegi pro me nhi khulegi
@RequiredArgsConstructor
@Data
public class BankUsernamePwdAUthenticationProvider implements AuthenticationProvider {


    // yha hm sari detail BankUserDetailSetrvice ki direct Authenticate meethod me bhi likh skte he alg class nhi bnake
    private final BankUserDetailsService bankUserDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
       UserDetails userDetails= bankUserDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(username , password , userDetails.getAuthorities());


        //yha hmne password ka validation bnd kr diya
//       if (passwordEncoder.matches(password , userDetails.getPassword())){
//
//           //agr age details varification bhi krna he to uska logic yha likh skte he
//           return new UsernamePasswordAuthenticationToken(username , password , userDetails.getAuthorities());
//       }else {
//           throw new BadCredentialsException("invalid password");
//       }


    }

    @Override
    public boolean supports(Class<?> authentication) {

        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
