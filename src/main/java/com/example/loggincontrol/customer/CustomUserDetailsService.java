package com.example.loggincontrol.customer;

import com.example.loggincontrol.admin.CustomUserDetails;
import com.example.loggincontrol.admin.User;
import com.example.loggincontrol.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired private CustomerRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = repo.findByEmail(username);

        if (customer == null){
            throw new UsernameNotFoundException("");
        }

        return new CustomerUserDetails(customer);
    }

}
