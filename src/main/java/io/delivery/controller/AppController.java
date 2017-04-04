package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.service.DBOperations;
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
    private DBOperations dbOperations;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }
    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("status", dbOperations.createTable());
        return "create";
    }
    @RequestMapping("/delete")
    public String delete(Model model){
        model.addAttribute("status", dbOperations.deleteFromTable());
        return "delete";
    }
    @RequestMapping("/insert")
    public String insert(Model model){
        model.addAttribute("status", dbOperations.insertToTable());
        return "insert";
    }
    @RequestMapping("/update")
    public String update(Model model){
        model.addAttribute("count", dbOperations.updateTable());
        return "update";
    }
    @RequestMapping("/backup")
    public String backup(Model model){
        model.addAttribute("status", dbOperations.backUp());
        return "backup";
    }
    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }
    @RequestMapping("/users")
    public String users(){
        return "users";
    }
}
