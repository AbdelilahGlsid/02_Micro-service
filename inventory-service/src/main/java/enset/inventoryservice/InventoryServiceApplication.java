package enset.inventoryservice;

import enset.inventoryservice.entities.Product;
import enset.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository,
                            RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"Ordinateur", 3000, 12));
            productRepository.save(new Product(null,"Imprimante", 1700, 8));
            productRepository.save(new Product(null,"Clavier", 120, 17));
            productRepository.findAll().forEach(p-> {
                System.out.println(p.getName());
            });
        };
    }

}
