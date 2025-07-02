package L03_Projection.config;

import org.modelmapper.*;
import org.springframework.context.annotation.*;

@Configuration
public class Config {

    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
