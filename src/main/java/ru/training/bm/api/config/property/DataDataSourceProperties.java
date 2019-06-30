package ru.training.bm.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataDataSourceProperties extends BaseDataSourceProperties {

}
