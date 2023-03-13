package com.example.jpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix=HibernateProperties.PROPERTIES_PREFIX,ignoreInvalidFields = true)
public class HibernateProperties {

    public static final String PROPERTIES_PREFIX = "hibernate";

    private String[] mappingLocations = new String[] { "classpath*:/config/hbm/*.xml" };

    private String[] packagesToScan;

    public String[] getMappingLocations() {
        return mappingLocations;
    }

    public void setMappingLocations(String[] mappingLocations) {
        this.mappingLocations = mappingLocations;
    }

    public String[] getPackagesToScan() {
        return packagesToScan;
    }

    public void setPackagesToScan(String[] packagesToScan) {
        this.packagesToScan = packagesToScan;
    }
}
