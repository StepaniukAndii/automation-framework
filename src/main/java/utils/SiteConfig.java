package utils;

import lombok.SneakyThrows;

import java.util.Properties;

public class SiteConfig {

    private static final String APPLICATION_PROPERTIES = "/application.properties";

    private final Properties properties;

    @SneakyThrows
    public SiteConfig() {
        properties = new Properties();
        properties.load(SiteConfig.class.getResourceAsStream(System.getProperty("application.properties", APPLICATION_PROPERTIES)));
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }
}
