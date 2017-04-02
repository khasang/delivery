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
    private CreateTable createTable;
    @Autowired
    private InsertInTable insertInTable;
    @Autowired
    private UpdateTable updateTable;
    @Autowired
    private Delete delete;


    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("status", createTable.createCompany());
        return "create";
    }

    @RequestMapping("/insert")
    public String insertInTable(Model model){
        model.addAttribute("status", insertInTable.createRow());
        return "insert";
    }

    @RequestMapping("/update")
    public String updateTable(Model model){
        model.addAttribute("status", updateTable.updateRows());
        return "update";
    }
    @RequestMapping("/delete")
    public String delete(Model model){
        model.addAttribute("status", delete.deleteRows());
        return "delete";
    }
}



