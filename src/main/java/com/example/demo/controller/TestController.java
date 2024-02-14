package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @RequestMapping("/list")
    public String list(Model model){
        List<String> list =new ArrayList<>();
        list.add("apple");
        list.add("banana");
        model.addAttribute("list", list);
        return "list";
    }
}
