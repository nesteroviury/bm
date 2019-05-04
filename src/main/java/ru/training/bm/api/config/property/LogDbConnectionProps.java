package ru.training.bm.api.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "connection")
public class LogDbConnectionProps {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private String jndiName;

}
