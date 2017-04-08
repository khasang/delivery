package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.model.TableCreator;
import io.delivery.service.QueryCreator;
import io.delivery.service.impl.*;
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
    private QueryCreator queryCreator;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("delete", queryCreator.createQuery(new DeleteTableImpl(), "Delete table"));
        model.addAttribute("status", queryCreator.createQuery(new CreateTableImpl(),"Table create"));
        return "create";
    }

    @RequestMapping("/ins")
    public String ins(Model model){
        model.addAttribute("status", queryCreator.createQuery(new InsertQueryImpl(),"Insert into table"));
        return "ins";
    }

    @RequestMapping("/update")
    public String update(Model model){
        model.addAttribute("status", queryCreator.createQuery(new UpdateQueryImpl(),"Update table"));
        return "update";
    }

    @RequestMapping("/del")
    public String del(Model model){
        model.addAttribute("status", queryCreator.createQuery(new DeleteQueryImpl(),"Delete from table"));
        return "del";
    }

    @RequestMapping("/upd")
    public String upd(Model model){
        model.addAttribute("status", queryCreator.updateQuery("PrepareStatment update"));
        return "upd";
    }

    @RequestMapping("/dump")
    public String dump(Model model) {
        model.addAttribute("dump", queryCreator.pgDump());
        return "dump";
    }

    @RequestMapping("/secure")
    public String secure() {
        return "/secure";
    }
}
