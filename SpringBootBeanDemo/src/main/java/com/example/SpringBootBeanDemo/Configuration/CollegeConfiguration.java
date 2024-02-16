package com.example.SpringBootBeanDemo.Configuration;

import com.example.SpringBootBeanDemo.Component.College;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollegeConfiguration {
    @Bean
    public College collegeBean()
    {
        // Returns the College object
        return new College();
    }
}
