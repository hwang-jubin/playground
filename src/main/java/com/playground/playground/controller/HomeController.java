package com.playground.playground.controller;

import com.playground.playground.domain.playground_Elements;
import com.playground.playground.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final PlaygroundService playgroundService;
    @Autowired
    public HomeController(PlaygroundService playgroundService) {
        this.playgroundService = playgroundService;
    }
    @GetMapping("/")
    public String details_view(Model model) {
        List<playground_Elements> elements = playgroundService.findMembers();
        model.addAttribute("elements", elements);
        return "home";
    }

}
