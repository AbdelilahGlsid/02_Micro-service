package enset.customerservice;

import enset.customerservice.entities.Customer;
import enset.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(null,"Ahmed", "ahmed@gmail.com"));
            customerRepository.save(new Customer(null,"Hassan", "hassan@gmail.com"));
            customerRepository.save(new Customer(null,"Yassmin", "yassmin@gmail.com"));
            customerRepository.findAll().forEach(c-> {
                System.out.println(c.toString());
            });
        };
    }

}
