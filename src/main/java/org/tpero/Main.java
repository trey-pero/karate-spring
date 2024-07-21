package org.tpero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan("org.tpero")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Main {
    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
