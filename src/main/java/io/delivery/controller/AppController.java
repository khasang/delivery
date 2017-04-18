package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.BackupCreator;
import io.delivery.model.Message;
import io.delivery.model.TableCreator;
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
    private TableCreator tableCreator;
    @Autowired
    private BackupCreator backupCreator;

    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }

    // localhost:8080
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }

    @RequestMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("status", tableCreator.createCompany());
        return "create";
    }

    @RequestMapping(value = "/backup")
    public String backup(Model model) {
        model.addAttribute("status", backupCreator.createBackup());
        return "create";
    }

    @RequestMapping(value = "/secure")
    public String secure() {
        return "/secure";
    }

    @RequestMapping(value = "/documentApi")
    public String getDocumentInfo(){
        return "document";
    }

    @RequestMapping(value = "/admin/users")
    public String getUsersInfo(){
        return "/admin/users";
    }
}
