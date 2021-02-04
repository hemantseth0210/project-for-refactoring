package com.example.springexternalproperties.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//If we don't use @Configuration in the POJO, then we need to add @EnableConfigurationProperties(MailProperties.class)
// in the main Spring application class to bind the properties into the POJO
//https://www.baeldung.com/configuration-properties-in-spring-boot
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailProperties {

    private String hostName;
    private int port;
    private String from;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
