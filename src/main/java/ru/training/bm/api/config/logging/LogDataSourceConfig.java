package ru.training.bm.api.config.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.training.bm.api.config.property.LogDbConnectionProps;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class LogDataSourceConfig {

    private final LogDbConnectionProps logDbConnectionProps;

    @Autowired
    public LogDataSourceConfig(LogDbConnectionProps logDbConnectionProps) {
        this.logDbConnectionProps = logDbConnectionProps;
    }

//logging jndi data source
/*
    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
                tomcat.enableNaming();

                return super.getTomcatWebServer(tomcat);
            }

            @Override
            protected void postProcessContext(Context context) {
                ContextResource resource = new ContextResource();

                resource.setName(logDbConnectionProps.getJndiName());
                resource.setType(DataSource.class.getName());
                resource.setProperty("driverClassName", logDbConnectionProps.getDriverClassName());
                resource.setProperty("username", logDbConnectionProps.getUsername());
                resource.setProperty("password", logDbConnectionProps.getPassword());
                resource.setProperty("url", logDbConnectionProps.getUrl());

                context.getNamingResources().addResource(resource);
            }
        };
    }

    @Bean(destroyMethod = "")
    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

        bean.setJndiName("java:/comp/env/" + logDbConnectionProps.getJndiName());
        bean.setProxyInterface(DataSource.class);
        bean.afterPropertiesSet();

        return (DataSource) bean.getObject();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws IllegalArgumentException, NamingException {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        vendorAdapter.setDatabase(Database.H2);
        vendorAdapter.setShowSql(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ru.training.bm.domain");
        factory.setDataSource(jndiDataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws IllegalArgumentException, NamingException {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());

        return txManager;
    }

*/
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(logDbConnectionProps.getDriverClassName());
        dataSource.setUrl(logDbConnectionProps.getUrl());
        dataSource.setUsername(logDbConnectionProps.getUsername());
        dataSource.setPassword(logDbConnectionProps.getPassword());

        return dataSource;
    }

}
