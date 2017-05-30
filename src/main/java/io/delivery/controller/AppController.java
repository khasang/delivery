package io.delivery.controller;

import io.delivery.messaging.MessageReceiver;
import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.service.*;
import net.yandex.speller.services.spellservice.Client;
import org.russianpost.ClientRussianPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.soap.SOAPException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@Controller
public class AppController {
    @Autowired
    private Answer answer;
    @Autowired
    private Message message;
    @Autowired
    private InsertUser insertUser;
    @Autowired
    private UpdateTable updateTable;
    @Autowired
    private SelectTable selectTable;
    @Autowired
    private PreparedSQL preparedSQL;
    @Autowired
    private Test test;
    @Autowired
    private Client client;
    @Autowired
    private ClientRussianPost clientRussianPost;
    @Autowired
    private MessageReceiver messageReceiver;

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

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
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

    @RequestMapping("/response")
    public String response(Model model) {
        model.addAttribute("orderList", messageReceiver.orderReceiver("ORDER_QUEUE"));
        return "response";
    }
}

