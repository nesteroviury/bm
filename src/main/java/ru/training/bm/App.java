package ru.training.bm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("ru.training.bm")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
