package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
    basePackages = "com.example.demo.entityone.repository",
    entityManagerFactoryRef = "firstDataSourceEntityManagerFactory",
    transactionManagerRef = "firstDataSourceTransactionManager"
)
public class DataSourceOneConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource firstDataSource() {
        DataSourceProperties securityDataSourceProperties = firstDataSourceProperties();
        return DataSourceBuilder.create()
            .driverClassName(securityDataSourceProperties.getDriverClassName())
            .url(securityDataSourceProperties.getUrl())
            .username(securityDataSourceProperties.getUsername())
            .password(securityDataSourceProperties.getPassword())
            .build();
    }

    @Bean
    public PlatformTransactionManager firstDataSourceTransactionManager()
    {
        EntityManagerFactory factory = firstDataSourceEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean firstDataSourceEntityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(firstDataSource());
        factory.setPackagesToScan(new String[]{"com.example.demo.entityone"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
        jpaProperties.put("hibernate.physical_naming_strategy", env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));
        factory.setJpaProperties(jpaProperties);

        return factory;
    }

    @Bean
    public DataSourceInitializer firstDataSourceInitializer()
    {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(firstDataSource());
//        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//        databasePopulator.addScript(new ClassPathResource("first-entity-data.sql"));
//        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(env.getProperty("spring.datasource.one.initialize", Boolean.class, false));
        return dataSourceInitializer;
    }

//    public static final String PACKAGE_ENTITIES_ONE = "com.example.demo.entityone";
//
//    @Bean
//    public DataSource dataSourceOne() {
//
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.one"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url.one"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username.one"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password.one"));
//
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean dataSourceOneEntityManager() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSourceOne());
//
//        // Scan Entities in Package:
//        em.setPackagesToScan(new String[] {PACKAGE_ENTITIES_ONE});
//        em.setPersistenceUnitName(Constants.JPA_UNIT_NAME_ONE);
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//
//        em.setJpaVendorAdapter(vendorAdapter);
//
//        HashMap<String, Object> properties = new HashMap<>();
//
//        // JPA & Hibernate
//        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect.one"));
//        properties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql.one"));
//
//        em.setJpaPropertyMap(properties);
//        em.afterPropertiesSet();
//
//        return em;
//    }
//
//    @Bean
//    public PlatformTransactionManager dataSourceTransactionManager() {
//
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(dataSourceOneEntityManager().getObject());
//        return transactionManager;
//    }
}
