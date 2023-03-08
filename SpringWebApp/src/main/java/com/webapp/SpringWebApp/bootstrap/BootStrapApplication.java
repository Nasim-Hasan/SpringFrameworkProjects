package com.webapp.SpringWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" ApplicationRunner called");
    }
}
