package com.playground.playground.controller;

import com.playground.playground.domain.playground_Elements;
import com.playground.playground.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class DetailController {

    private final PlaygroundService playgroundService;

    @Autowired
    public DetailController(PlaygroundService playgroundService) {
        this.playgroundService = playgroundService;
    }

    @GetMapping("/detail/{id}")
    public String detailsView(@PathVariable Long id, Model model) {
        Optional<playground_Elements> element = playgroundService.findOne(id);
        model.addAttribute("element", element);
        return "playground_Info";
    }
}