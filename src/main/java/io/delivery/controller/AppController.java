package io.delivery.controller;

import io.delivery.model.*;
import io.delivery.model.impl.TableCreatorImpl;
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
    private TableInsertor tableInsertor;
    @Autowired
    private TableUpdated tableUpdated;
    @Autowired
    private TableDeleted tableDeleted;
    @Autowired
    private TableInnerSelecter tableInnerSelecter;

    // localhost:8080
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
        model.addAttribute("status", tableInsertor.insertCompany());
        return "insert";
    }

    @RequestMapping("/update")
    public String update(Model model){
        model.addAttribute("status", tableUpdated.updateCompany());
        return "update";
    }

    @RequestMapping("/delete")
    public String delete(Model model){
        model.addAttribute("status", tableDeleted.deleteCompany());
        return "delete";
    }

    @RequestMapping("/innerSelect")
    public String innerSelect(Model model){
        model.addAttribute("status", tableInnerSelecter.innerCompany());
        return "innerSelect";
    }

    @RequestMapping("/secure")
    public String secure(){
        return "/secure";
    }
}
