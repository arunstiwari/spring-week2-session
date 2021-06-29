package com.sapient.springsession.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam String mood, Model model) {
      log.info(" mood of the user : {}",mood);
      String message = "happy".equals(mood)? "You seem to be happy": "Things will be better";
       model.addAttribute("msg",message);
        return "greeting";
    }

    @GetMapping("/greeting/{name}")
    public String greetingWithName(@PathVariable String name, @RequestParam String mood, Model model) {
        log.info(" mood of the {} : {}",name, mood);
        String message = "happy".equals(mood)? name+ ": You seem to be happy": name+": Things will be better";
        model.addAttribute("msg",message);
        return "greeting";
    }
}
