package com.health.enroll;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class HealthEnrollStatusApplication implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(HealthEnrollStatusApplication.class);
	
    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {
        logger.info("server.port: " + System.getProperty("server.port"));
        for (String arg : args) {
            logger.info(arg);
        }

        if (environment != null) {
            getActiveProfiles();
        }
    }

    private void getActiveProfiles() {
        for (final String profileName : environment.getActiveProfiles()) {
            logger.info("Currently active profile - " + profileName);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(HealthEnrollStatusApplication.class, args);
    }

}

