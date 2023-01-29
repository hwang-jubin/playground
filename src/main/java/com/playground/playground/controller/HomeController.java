package com.playground.playground.controller;

import com.playground.playground.domain.playground_Elements;
import com.playground.playground.service.detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final detailService detailservice;
    @Autowired
    public HomeController(detailService detailservice) {
        this.detailservice = detailservice;
    }
    @GetMapping("/")
    public String details_view(Model model) {
        List<playground_Elements> elements = detailservice.findMembers();
        model.addAttribute("elements", elements);
        return "home";
    }
}
