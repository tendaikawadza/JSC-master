package Inventory.Management.Cofig;


import Inventory.Management.Entity.Product;
import Inventory.Management.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Id;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Configuration
public class ProductConfig {
           @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
             return args -> {

              Product Bond  =       new Product(

                               LocalDate.of(2000,Month.APRIL,9),
                               "Critical",
                               "45454545",
                               80,
                               70,
                               "Critical"


                       );

                 Product  tick =       new Product(

                         LocalDate.of(2000,Month.APRIL,9),
                         "Critical",
                         "45454545",
                         800,
                         77,
                         "Critical"


                 );                 repository.saveAll(

                           List.of(Bond,tick)
                   );




             };


    }




}
