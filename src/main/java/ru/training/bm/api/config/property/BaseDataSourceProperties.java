package ru.training.bm.api.config.property;

import lombok.Data;

@Data
public abstract class BaseDataSourceProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;

}
