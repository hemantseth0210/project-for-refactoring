package com.sethjava.springdata.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mySqlEntityManagerFactory",
        transactionManagerRef = "mySqlTransactionManager",
        basePackages = {"com.sethjava.springdata.repository.mysql"}
)
public class MySqlDbConfig {

    // Create Bean definition for MySQL DB Datasource
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mySqlDataSource() {
        return DataSourceBuilder.create().build();
        /*
        # Does not require to set datasource like this but if needed then can be configured like below also

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;

         */
    }

    // Create Bean definition for MySQL Entity Manager Factory
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mySqlDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.sethjava.springdata.model.mysql")
                .persistenceUnit("userdb")
                .build();
        /*
        # Does not require to set properties and adapter but if needed then can be configured like below

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        em.setJpaPropertyMap(properties);
        return em;

         */
    }

    // Create Bean definition for MySQL Transaction Manager
    @Primary
    @Bean
    public PlatformTransactionManager mySqlTransactionManager(
            @Qualifier("mySqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
