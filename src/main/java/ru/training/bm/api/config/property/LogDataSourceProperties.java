package ru.training.bm.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "log.datasource")
public class LogDataSourceProperties extends BaseDataSourceProperties{

}
