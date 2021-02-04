package com.example.springexternalproperties.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

@Configuration
@PropertySource("classpath:conversion.properties")
@ConfigurationProperties(prefix = "conversion")
public class ConversionProperties {
    private DataSize sizeInDefaultUnit;

    private DataSize sizeInGB;

    @DataSizeUnit(DataUnit.TERABYTES)
    private DataSize sizeInTB;

    public DataSize getSizeInDefaultUnit() {
        return sizeInDefaultUnit;
    }

    public void setSizeInDefaultUnit(DataSize sizeInDefaultUnit) {
        this.sizeInDefaultUnit = sizeInDefaultUnit;
    }

    public DataSize getSizeInGB() {
        return sizeInGB;
    }

    public void setSizeInGB(DataSize sizeInGB) {
        this.sizeInGB = sizeInGB;
    }

    public DataSize getSizeInTB() {
        return sizeInTB;
    }

    public void setSizeInTB(DataSize sizeInTB) {
        this.sizeInTB = sizeInTB;
    }
}
