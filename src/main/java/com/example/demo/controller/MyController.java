package com.example.demo.controller;

import com.example.demo.model.Pizza;
import com.example.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Autowired
    MyRepository repository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public @ResponseBody String addPizza(@RequestParam String name,
                                         @RequestParam Integer size) {
        Pizza pizza = new Pizza(name, size);
        repository.save(pizza);
        return "Saved!";
    }

    @GetMapping("/list")
    public @ResponseBody Iterable<Pizza> getAll() {
        return repository.findAll();
    }

    @GetMapping("/delete")
    public @ResponseBody String deletePizza(@RequestParam Integer id) {
        repository.deleteById(id);
        return "Deleted!";
    }


}
