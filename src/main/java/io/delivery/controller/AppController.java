package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.service.CreateTable;
import io.delivery.service.InsertItem;
import io.delivery.service.PgDump;
import io.delivery.service.Prepared;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    @Autowired
    private Prepared prepared;
    @Autowired
    private PgDump pgDump;

    // localhost:8080
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
        model.addAttribute("status", insertItem.insertItem());
        return "insert";
    }

    @RequestMapping("/update")
    public String update(Model model) {
        model.addAttribute("status", prepared.update());
        return "update";
    }

    @RequestMapping(value = "/dump")
    public String dump(Model model) {
        model.addAttribute("status", pgDump.dump());
        return "dump";
    }

    @RequestMapping(value = "/secure")
    public String secure() {
        return "secure";
    }

    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }

}

