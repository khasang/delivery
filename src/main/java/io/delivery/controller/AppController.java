package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.model.TableCreator;
import io.delivery.service.DAO;
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
    private DAO companyDAO;

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

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("status", companyDAO.createTable());
        return "create";
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("number", companyDAO.insertValues());
        return "insert";
    }

    @RequestMapping("/update")
    public String update(Model model) {
        model.addAttribute("updateNumber", companyDAO.update());
        return "update";
    }

    @RequestMapping("/delete")
    public String delete(Model model) {
        model.addAttribute("deleted", companyDAO.delete());
        return "delete";
    }

    @RequestMapping("/backup")
    public void backup() {
        companyDAO.backup();
    }


}
