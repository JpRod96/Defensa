package com.ucbcba.taller.controllers;

import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController
{

    @RequestMapping("/")
    String home() {
        return "root";
    }

}
