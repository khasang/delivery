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
    @Autowired
    private TableSelector tableSelector;

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
        model.addAttribute("insert", tableInsertor.insertNewDataIntoTable());
        return "insert";
    }

    @RequestMapping("/update")
    public String update(Model model){
        model.addAttribute("update", tableUpdater.updateDataInTable());
        return "update";
    }

    @RequestMapping("/delete")
    public String delete(Model model){
        model.addAttribute("delete", tableDeletor.deleteExistingTable());
        return "delete";
    }

    @RequestMapping("/select")
    public String select(Model model){
        model.addAttribute("select", tableSelector.selectDataFromTable());
        return "select";
    }

}
