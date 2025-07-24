package E02_Car_Dealer.config;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.*;
import com.google.gson.*;
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
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    XmlMapper xmlMapper() {
        return new XmlMapper();
    }

}