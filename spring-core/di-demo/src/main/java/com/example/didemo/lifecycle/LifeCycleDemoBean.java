package com.example.didemo.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean  implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("##### The LifeCycleDemoBean Constructor called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("##### The LifeCycleDemoBean has it's properties set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("##### The LifeCycleDemoBean destroy method");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("##### The LifeCycleDemoBean setBeanName method");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("##### The LifeCycleDemoBean setBeanFactory method");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("##### The LifeCycleDemoBean setApplicationContext method");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("##### The LifeCycleDemoBean postConstruct method");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("##### The LifeCycleDemoBean preDestroy method");
    }

    public void beforeInit(){
        System.out.println("##### The LifeCycleDemoBean beforeInit method - called by BeanPostProcessor");
    }

    public void afterInit(){
        System.out.println("##### The LifeCycleDemoBean afterInit method - called by BeanPostProcessor");
    }
}
