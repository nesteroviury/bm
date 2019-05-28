package ru.training.bm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Context;

@RestController
@EnableAutoConfiguration
@ComponentScan("ru.training.bm")
public class App {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        initJndi();

        SpringApplication.run(App.class, args);
    }

    private static void initJndi() {
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
//        System.setProperty(Context.PROVIDER_URL, "localhost:1099");
    }

}
