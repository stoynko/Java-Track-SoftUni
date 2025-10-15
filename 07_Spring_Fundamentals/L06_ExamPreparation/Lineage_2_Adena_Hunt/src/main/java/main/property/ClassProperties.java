package main.property;

import jakarta.persistence.Column;
import lombok.Data;
import main.config.YamlPropertySourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties
@PropertySource(value = "class-details.yaml", factory = YamlPropertySourceFactory.class)

public class ClassProperties {

    private String playerClass;

    private String bannerImg;

    private double health;

    private double attack;

    private double defense;
}
