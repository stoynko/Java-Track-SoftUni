package E02_Car_Dealer.config;

import E02_Car_Dealer.data.dtos.supplier.export.*;
import E02_Car_Dealer.data.entities.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.*;
import com.google.gson.*;
import org.aspectj.apache.bcel.classfile.*;
import org.aspectj.apache.bcel.classfile.Module;
import org.modelmapper.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

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
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JacksonXmlModule()).configure(SerializationFeature.INDENT_OUTPUT, true);
        return xmlMapper;
    }

}