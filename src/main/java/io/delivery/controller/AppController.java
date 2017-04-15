package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.service.*;
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
    private InsertUser insertUser;
    @Autowired
    private UpdateTable updateTable;
    @Autowired
    private SelectTable selectTable;
    @Autowired
    private PreparedSQL preparedSQL;
    @Autowired
    private DumpDB dumpDB;
    @Autowired
    private Test test;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("status", createTable.createCompany());
        return "create";
    }

    @RequestMapping("/insert")
    public  String insert(Model model){
        model.addAttribute("status", insertUser.insertUser());
        return "insert";
    }

    @RequestMapping("/update")
    public  String update(Model model){
        model.addAttribute("status", updateTable.updateTable());
        return  "update";
    }

    @RequestMapping("/select")
    public  String select(Model model) {
        model.addAttribute("status", selectTable.selectTable());
        return "select";
    }

    @RequestMapping("/prepared")
    public String prepared(Model model) {
        model.addAttribute("status", preparedSQL.execute());
        return "prepared";
    }

    @RequestMapping("/dump")
    public String dumpDB(Model model) {
        model.addAttribute("status", dumpDB.execute());
        return "dump";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("status", test.toString());
        return "test";
    }

    @RequestMapping("/map")
    public String map(Model model) {
        //model.addAttribute("status", "Map is loaded");
        return "map";
    }

    @RequestMapping("/secure")
    public String secure() {
        return "secure";
    }

    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("password", password);
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }
}
