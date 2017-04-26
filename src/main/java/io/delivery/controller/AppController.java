package io.delivery.controller;

import https.www_w3schools_com.xml.ClientTemp;
import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.model.TableCreator;
import io.delivery.service.*;
import net.webservicex.ConversionRate;
import net.webservicex.Currency;
import net.webservicex.CurrencyClient;
import net.yandex.speller.services.spellservice.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private CurrencyClient currencyClient;
    @Autowired
    private ConversionRate conversionRate;
    @Autowired
    private ClientTemp clientTemp;


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

    @RequestMapping(value = {"/currency/{convert}"}, method = RequestMethod.GET)
    /**
     * http://localhost:8080/currency/CAD?to=EUR
     */
    public ModelAndView currencyConvertor(@PathVariable("convert") Currency convert,
                                          @RequestParam (value = "to") Currency toCurrency) throws IOException, SOAPException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("resultconvert");
        modelAndView.addObject("result", currencyClient.result(convert, toCurrency));
        modelAndView.addObject("fromCurrency", conversionRate.getFromCurrency());
        modelAndView.addObject("to", conversionRate.getToCurrency());
        return modelAndView;
    }

       @RequestMapping(value = {"/temp/{convert}"}, method = RequestMethod.GET)
    public ModelAndView convertTemp(@PathVariable("convert") String convert) throws IOException, SOAPException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("temperatur");
        modelAndView.addObject("convertTemp", clientTemp.result(convert));
        return modelAndView;
    }
}
