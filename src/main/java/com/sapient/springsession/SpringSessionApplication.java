package com.sapient.springsession;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringSessionApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringSessionApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
