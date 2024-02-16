package com.example.SpringBootBeanDemo.Component;

import org.springframework.stereotype.Component;

@Component("collegeBean")
public class College {
    public void test()
    {
        // Print statement
        System.out.println("Test College Method");
    }
}
