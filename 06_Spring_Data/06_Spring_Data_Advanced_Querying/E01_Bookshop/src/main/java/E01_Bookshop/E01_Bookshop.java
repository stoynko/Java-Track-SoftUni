package E01_Bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import java.util.*;

@SpringBootApplication
public class E01_Bookshop {

    public static void main(String[] args) {
        SpringApplication.run(E01_Bookshop.class, args);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
