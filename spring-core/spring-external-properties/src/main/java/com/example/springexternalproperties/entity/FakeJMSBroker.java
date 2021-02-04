package com.example.springexternalproperties.entity;

public class FakeJMSBroker {
    private String jmsUsername;
    private String jmsPassword;
    private String jmsUrl;

    public FakeJMSBroker(String jmsUsername, String jmsPassword, String jmsUrl) {
        this.jmsUsername = jmsUsername;
        this.jmsPassword = jmsPassword;
        this.jmsUrl = jmsUrl;
    }

    public String getJmsUsername() {
        return jmsUsername;
    }

    public void setJmsUsername(String jmsUsername) {
        this.jmsUsername = jmsUsername;
    }

    public String getJmsPassword() {
        return jmsPassword;
    }

    public void setJmsPassword(String jmsPassword) {
        this.jmsPassword = jmsPassword;
    }

    public String getJmsUrl() {
        return jmsUrl;
    }

    public void setJmsUrl(String jmsUrl) {
        this.jmsUrl = jmsUrl;
    }
}
