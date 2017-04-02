package io.delivery.controller;

import io.delivery.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private Answer answer;
    @Autowired
    private Message message;
    @Autowired
    private TableCreator tableCreator;
    @Autowired
    private TableInserter tableInserter;
    @Autowired
    private TableUpdater tableUpdater;
    @Autowired
    private TableDeleter tableDeleter;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("status", tableCreator.createCompany());
        return "create";
    }

    @RequestMapping("/insert")
    public String insert(Model model){
        model.addAttribute("insert", tableInserter.insertValue());
        return "insert";
    }

    @RequestMapping("/update")
    public String update(Model model){
        model.addAttribute("update", tableUpdater.updateValue());
        return "update";
    }

    @RequestMapping("/delete")
    public String delete(Model model){
        model.addAttribute("delete", tableDeleter.deleteValue());
        return "delete";
    }
}
