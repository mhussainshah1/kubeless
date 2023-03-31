package com.laurentiuspilica.springboot101.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * combination of
    1.  @Controller
    2.  @ResponseBody
*/
public class HelloController {
    @RequestMapping("/hello") //GET, POST
    //automatically create mapping of path over base url
    public String hello(){
        return "Hello"; //locate static page in resources/static folder and render the page as a body
    }
}