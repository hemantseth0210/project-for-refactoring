package com.example.springexternalproperties.config;

import com.example.springexternalproperties.entity.FakeDatasource;
import com.example.springexternalproperties.entity.FakeJMSBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${db.url}")
    private String url;

    @Value("${jms.username}")
    private String jmsUsername;

    @Value("${jms.password}")
    private String jmsPassword;

    @Value("${jms.url}")
    private String jmsUrl;


    @Bean
    public FakeDatasource fakeDatasource(){

        //return new FakeDatasource(username, password, url);
        //using environment object
        return new FakeDatasource(env.getProperty("USERNAME"), password, url);
    }

    @Bean
    public FakeJMSBroker fakeJMSBroker(){
        return new FakeJMSBroker(jmsUsername, jmsPassword, jmsUrl);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
