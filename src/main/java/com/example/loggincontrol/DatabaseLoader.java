package com.example.loggincontrol;

import com.example.loggincontrol.admin.User;
import com.example.loggincontrol.admin.UserRepository;
import com.example.loggincontrol.customer.Customer;
import com.example.loggincontrol.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseLoader {
    private UserRepository userRepo;
    private CustomerRepository customerRepo;


    public DatabaseLoader(UserRepository userRepo, CustomerRepository customerRepo) {
        this.userRepo = userRepo;
        this.customerRepo = customerRepo;
    }

    @Bean
    public CommandLineRunner initilizeDatabase(){
        return args -> {

            //Inicializacion y creacion de datos de cuentas admin.
            User user1 = new User("admin", "1234");
            User user2 = new User("admin2", "1234");

            userRepo.saveAll(List.of(user1,user2));

            //Inicializacion y creacion de datos de cuentas customer.
            Customer customer1 = new Customer("oscar", "1234","Oscar Alexander");
            Customer customer2 = new Customer("lucas", "1234", "Lucas Modric");

            customerRepo.saveAll(List.of(customer1,customer2));

            System.out.println("Prueba de inicializacion");
        };
    }
}
