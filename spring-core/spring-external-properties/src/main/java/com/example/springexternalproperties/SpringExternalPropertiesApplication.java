package com.example.springexternalproperties;

import com.example.springexternalproperties.config.ConversionProperties;
import com.example.springexternalproperties.entity.FakeDatasource;
import com.example.springexternalproperties.entity.FakeJMSBroker;
import com.example.springexternalproperties.entity.MailDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringExternalPropertiesApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SpringExternalPropertiesApplication.class, args);
        FakeDatasource fakeDatasource = ctx.getBean(FakeDatasource.class);
        System.out.println(fakeDatasource.getUsername());

        FakeJMSBroker fakeJMSBroker = ctx.getBean(FakeJMSBroker.class);
        System.out.println(fakeJMSBroker.getJmsUsername());

        MailDetails mailDetails = ctx.getBean(MailDetails.class);
        System.out.println(mailDetails.getDetails());

        ConversionProperties conversionProperties = ctx.getBean(ConversionProperties.class);
        System.out.println(conversionProperties.getSizeInDefaultUnit().toBytes()
                +" -- "+  conversionProperties.getSizeInGB().toGigabytes()
                + " -- "+ conversionProperties.getSizeInTB().toTerabytes());

    }

}
