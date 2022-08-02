package com.example.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@Controller
public class CicdApplication {

    @GetMapping("/")
    public @ResponseBody String front(){
        return "hey!";
    }

    public static void main(String[] args) {
        SpringApplication.run(CicdApplication.class, args);
    }

}
