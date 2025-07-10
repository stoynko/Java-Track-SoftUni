package E01_Products_Shop.config;

import E01_Products_Shop.service.utilities.*;
import com.fasterxml.jackson.databind.*;
import com.google.gson.*;
import jakarta.validation.*;
import org.modelmapper.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

@Service
public class BeanConfigurations {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    ObjectMapper objectMapper() {return new ObjectMapper(); }

    @Bean
    Gson gson() {
        return new Gson();
    }
}
