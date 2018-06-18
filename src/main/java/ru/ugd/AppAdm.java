package ru.ugd;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import ru.ugd.config.AppAdmConfig;

@SpringBootApplication
public class AppAdm extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(AppAdmConfig.class, args);
    }
}
