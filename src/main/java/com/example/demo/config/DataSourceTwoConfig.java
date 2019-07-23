package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@PropertySources(
//    { @PropertySource("classpath:datasource.properties") }
//)
@EnableJpaRepositories(
    basePackages = "com.example.demo.entitytwo.repository",
    entityManagerFactoryRef = "secondDataSourceEntityManagerFactory",
    transactionManagerRef = "secondDataSourceTransactionManager"
)
public class DataSourceTwoConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource secondDataSource() {
        DataSourceProperties securityDataSourceProperties = secondDataSourceProperties();
        return DataSourceBuilder.create()
            .driverClassName(securityDataSourceProperties.getDriverClassName())
            .url(securityDataSourceProperties.getUrl())
            .username(securityDataSourceProperties.getUsername())
            .password(securityDataSourceProperties.getPassword())
            .build();
    }

    @Bean
    public PlatformTransactionManager secondDataSourceTransactionManager()
    {
        EntityManagerFactory factory = secondDataSourceEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondDataSourceEntityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(secondDataSource());
        factory.setPackagesToScan(new String[]{"com.example.demo.entitytwo"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
        factory.setJpaProperties(jpaProperties);

        return factory;
    }

    @Bean
    public DataSourceInitializer secondDataSourceInitializer()
    {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(secondDataSource());
//        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//        databasePopulator.addScript(new ClassPathResource("second-entity-data.sql"));
//        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(env.getProperty("spring.datasource.two.initialize", Boolean.class, false));
        return dataSourceInitializer;
    }

//    public static final String PACKAGE_ENTITIES_TWO = "com.example.demo.entitytwo";
//
//    @Bean
//    public DataSource dataSourceTwo() {
//
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.two"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url.two"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username.two"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password.two"));
//
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean dataSourceTwoEntityManager() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSourceTwo());
//
//        // Scan Entities in Package:
//        em.setPackagesToScan(new String[] { PACKAGE_ENTITIES_TWO });
//        em.setPersistenceUnitName(Constants.JPA_UNIT_NAME_TWO);
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//
//        em.setJpaVendorAdapter(vendorAdapter);
//
//        HashMap<String, Object> properties = new HashMap<>();
//
//        // JPA & Hibernate
//        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect.two"));
//        properties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql.two"));
//
//        em.setJpaPropertyMap(properties);
//        em.afterPropertiesSet();
//
//        return em;
//    }
//
//    @Bean
//    public PlatformTransactionManager dataSourceTwoTransactionManager() {
//
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(dataSourceTwoEntityManager().getObject());
//        return transactionManager;
//    }
}
