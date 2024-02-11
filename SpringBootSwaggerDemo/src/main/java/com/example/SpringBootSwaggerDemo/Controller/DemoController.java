package com.example.SpringBootSwaggerDemo.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value="/demo")
    @ApiOperation (value = "Just a Get Operation")
    public String getMessage( @ApiParam(
            name =  "input",
            value = "anything",
            required = true)@RequestParam(value="input", required = false)String input){
        return "Success";
    }
}
