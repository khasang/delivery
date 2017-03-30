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
    private TableInsertor tableInsertor;
    @Autowired
    private TableUpdater tableUpdater;
    @Autowired
    private TableDeletor tableDeletor;

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
        model.addAttribute("insert", tableInsertor.insertNewDataIntoTable("insert into " +
                "companies (code, title, did) values(11111, 'Title_1', 10)"));
        return "insert";
    }

    @RequestMapping("/update")
    public String update(Model model){
        model.addAttribute("update", tableUpdater.updateDataInTable("update companies " +
                "set code='22222', title='Title_2', did='22' " +
                "where code='11111'"));
        return "update";
    }

    @RequestMapping("/delete")
    public String delete(Model model){
        model.addAttribute("delete", tableDeletor.deleteExistingTable());
        return "delete";
    }
}
