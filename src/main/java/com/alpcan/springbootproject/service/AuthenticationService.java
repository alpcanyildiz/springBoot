package com.alpcan.springbootproject.service;

import com.alpcan.springbootproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class AuthenticationService implements AuthenticationProvider
{

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        System.out.println("Textten gelen password"+password);


        User user = userService.findByUserUsernameAndPassword(userName, password);

        if (user == null) {
            throw new UsernameNotFoundException("Login Failed. Password and Username did not match.");
        }
         if(!user.isActive()){
            return null;
        }
      //   if (! bCryptPasswordEncoder.matches(password,user.getPassword())){
      //      System.out.println("Did not match.");
      //     return null;
      // }

        String roles = user.getRoles()
                .stream()
                .map(role -> "ROLE_" + role.getRole())
                .collect(Collectors.joining(","));

        System.out.println("alpcan "+roles);
        return new UsernamePasswordAuthenticationToken(userName, password, AuthorityUtils.commaSeparatedStringToAuthorityList(roles));
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
