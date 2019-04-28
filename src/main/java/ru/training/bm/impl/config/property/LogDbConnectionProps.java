package ru.training.bm.impl.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "connection")
public class LogDbConnectionProps {

    String url;
    String username;
    String password;
    String driverClassName;
    String jndiName;



}
