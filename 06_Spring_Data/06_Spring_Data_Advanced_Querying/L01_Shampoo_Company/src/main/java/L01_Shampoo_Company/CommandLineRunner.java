package L01_Shampoo_Company;

import L01_Shampoo_Company.repositories.*;
import jakarta.persistence.*;
import org.springframework.stereotype.*;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final ShampooRepository shampoosRepository;

    public CommandLineRunner(ShampooRepository shampoosRepository) {
        this.shampoosRepository = shampoosRepository;
    }
    @Override
    public void run(String... args) throws Exception {

    }
}
