package E01_Products_Shop.config;

import E01_Products_Shop.service.utilities.*;
import com.fasterxml.jackson.databind.*;
import com.google.gson.*;
import jakarta.validation.*;
import org.modelmapper.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

@Service
public class BeanConfigurations {

    @Bean
    BufferedReader reader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    ObjectMapper objectMapper() {return new ObjectMapper(); }

    @Bean
    Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }
}
