package E01_SoftUni_Game_Store.configurations;

import org.modelmapper.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class BeanConfigurations {

    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
