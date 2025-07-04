package E01_SoftUni_Game_Store.configurations;

import E01_SoftUni_Game_Store.core.*;
import E01_SoftUni_Game_Store.service.*;
import E01_SoftUni_Game_Store.service.implementations.*;
import org.modelmapper.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.*;

@Configuration
public class BeanConfigurations {

    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public static BufferedReader reader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
