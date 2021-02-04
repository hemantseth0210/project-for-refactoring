package com.example.springexternalproperties.entity;

import com.example.springexternalproperties.config.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailDetails {

    @Autowired
    MailProperties mailProperties;

    private String details;

    public String getDetails() {
        return mailProperties.getHostName() +" --- "+ mailProperties.getFrom()+" --- "+ mailProperties.getPort();
    }

}
