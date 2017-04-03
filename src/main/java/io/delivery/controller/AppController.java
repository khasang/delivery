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
    private TableDAO tableDAO;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("status", tableDAO.createCompany());
        return "create";
    }

    @RequestMapping("/insert")
    public String insert(Model model){
        model.addAttribute("insert", tableDAO.insertNewDataIntoTable());
        return "insert";
    }

    @RequestMapping("/update")
    public String update(Model model){
        model.addAttribute("update", tableDAO.updateDataInTable());
        return "update";
    }

    @RequestMapping("/delete")
    public String delete(Model model){
        model.addAttribute("delete", tableDAO.deleteExistingTable());
        return "delete";
    }

    @RequestMapping("/select")
    public String select(Model model){
        model.addAttribute("select", tableDAO.selectDataFromTable());
        return "select";
    }

}
