package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.model.TableCreator;
<<<<<<< HEAD
import io.delivery.service.QueryCreator;
import io.delivery.service.impl.*;
=======
import io.delivery.service.*;
import net.yandex.speller.services.spellservice.Client;
import org.russianpost.ClientRussianPost;
>>>>>>> origin/feedback
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
<<<<<<< HEAD
=======

import javax.xml.soap.SOAPException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
>>>>>>> origin/feedback

@Controller
public class AppController {
    @Autowired
    private Answer answer;
    @Autowired
    private Message message;
    @Autowired
<<<<<<< HEAD
    private QueryCreator queryCreator;
=======
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
    private TableCreator tableCreator;
    @Autowired
    private Test test;
    @Autowired
    private Client client;
    @Autowired
    private ClientRussianPost clientRussianPost;

    @RequestMapping(value = "/order")
    public String getOrderInfo() {
        return "order";
    }

    @RequestMapping(value = "/country")
    public String getCountryInfo() {
        return "country";
    }

    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }
>>>>>>> origin/feedback

    // localhost:8080
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }

<<<<<<< HEAD
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

    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }
=======
    @RequestMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("status", tableCreator.createCompany());
        return "create";
    }

    @RequestMapping(value = "/secure")
    public String secure() {
        return "/secure";
    }

    @RequestMapping(value = "/registration")
    public String registration() {
        return "/registration";
    }

    @RequestMapping(value = "/noregistration")
    public String noregisration() {
        return "/noregistration";
    }

    @RequestMapping(value = "/documentApi")
    public String getDocumentInfo() {
        return "document";
    }

    @RequestMapping(value = {"/word/{check}"}, method = RequestMethod.GET)
    public ModelAndView checkWord(@PathVariable("check") String check) throws IOException, SOAPException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("spell");
        modelAndView.addObject("info", client.result(check));

        return modelAndView;
    }

    @RequestMapping(value = {"/russianpost/{barcode}"}, method = RequestMethod.GET)
    public ModelAndView getOperationHistory(@PathVariable("barcode") String barcode) throws IOException, SOAPException, TransformerException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("russianpost");
        modelAndView.addObject("info", clientRussianPost.result(barcode));
        return modelAndView;
    }

    @RequestMapping(value = "/feedback")
    public String feedBack() {
        return "feedback";
    }
>>>>>>> origin/feedback
}
