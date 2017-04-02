package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.Company;
import io.delivery.model.Message;
import io.delivery.service.CreateTable;
import io.delivery.service.InsertItem;
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
    private CreateTable createTable;
    @Autowired
    private InsertItem insertItem;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("status", createTable.createCompany());
        return "create";
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("status", insertItem.createItem(new Company(1, "Google", 1500)));
        return "insert";
    }
}
