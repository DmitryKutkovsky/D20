package com.study.D20.controller;


import com.study.D20.domain.User;
import com.study.D20.repos.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<User> users = userDetailsRepo.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<User> users = null;

        if (filter.equals ( "Speaker" )) {
            users = userDetailsRepo.findByStatus (filter);
            model.put("users", users);
        } 



        return "main";
    }
}