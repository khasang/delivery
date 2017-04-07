package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.model.CompanyDAO;
import io.delivery.service.DbBackup;
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
    private CompanyDAO companyDAO;
    @Autowired
    private DbBackup dbBackup;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("status", companyDAO.createCompanyTable());
        return "create";
    }

    @RequestMapping("/secure")
    public String secure(){
        return "/secure";
    }

    @RequestMapping("/dbBackup")
    public String dbBackup(Model model) {
        model.addAttribute("status", dbBackup.makeBackup());
        return "create";
    }

}
