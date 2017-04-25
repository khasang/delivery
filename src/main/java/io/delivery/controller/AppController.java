package io.delivery.controller;

import io.delivery.by.belavia.webservices.Client;
import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.model.TableCreator;
import io.delivery.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.soap.SOAPException;
import java.io.IOException;

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
    private TableCreator tableCreator;
    @Autowired
    private Test test;
    @Autowired
    private Client client;

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
    public String getDocumentInfo(){
        return "document";
    }

    @RequestMapping(value = {"/belavia/airports/{language}"}, method = RequestMethod.GET)
    public ModelAndView getAirportsList(@PathVariable("language") String language) throws IOException, SOAPException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("airports");
        modelAndView.addObject("info", client.getListOfAirports(language));
        return modelAndView;
    }

    @RequestMapping(value = {"/belavia/timetable/{airport}/{type}/{date}"}, method = RequestMethod.GET)
    public ModelAndView getListOfFlights(@PathVariable("airport") String airport,
                                         @PathVariable("type") String type,
                                         @PathVariable("date") String date) throws IOException, SOAPException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("timetable");
        modelAndView.addObject("data", client.getListOfFlights(airport, type, date));
        return modelAndView;
    }
}
