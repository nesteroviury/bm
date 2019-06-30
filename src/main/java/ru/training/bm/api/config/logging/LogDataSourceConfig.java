package ru.training.bm.api.config.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.training.bm.api.config.property.LogDataSourceProperties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "logEntityManagerFactory",
        transactionManagerRef = "logTransactionManager",
        basePackages = {"ru.training.bm.repository.logging"}
)
public class LogDataSourceConfig {

    private final LogDataSourceProperties logDataSourceProperties;

    @Autowired
    public LogDataSourceConfig(LogDataSourceProperties logDataSourceProperties) {
        this.logDataSourceProperties = logDataSourceProperties;
    }

    @Bean(name = "logDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(logDataSourceProperties.getDriverClassName());
        dataSource.setUrl(logDataSourceProperties.getUrl());
        dataSource.setUsername(logDataSourceProperties.getUsername());
        dataSource.setPassword(logDataSourceProperties.getPassword());
        dataSource.setSchema("LOG");

        return dataSource;
    }

    @Bean(name = "logEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("logDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("ru.training.bm.domain")
                .persistenceUnit("log")
                .build();
    }

    @Bean(name = "logTransactionManager")
    public PlatformTransactionManager barTransactionManager(@Qualifier("logEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
