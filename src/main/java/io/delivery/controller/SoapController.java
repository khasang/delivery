package io.delivery.controller;

import io.delivery.by.belavia.webservices.ClientBelaviaAirlines;
import io.delivery.net.webservicex.ClientWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.soap.SOAPException;
import java.io.IOException;

@Controller
@RequestMapping("/soap")
public class SoapController {
    final private ClientBelaviaAirlines clientBelaviaAirlines;
    final private ClientWeather clientWeather;


    @Autowired
    public SoapController(ClientBelaviaAirlines clientBelaviaAirlines, ClientWeather clientWeather) {
        this.clientBelaviaAirlines = clientBelaviaAirlines;
        this.clientWeather = clientWeather;
    }

    @RequestMapping(value = {"/belavia/airports/{language}"}, method = RequestMethod.GET)
    public ModelAndView getAirportsList(@PathVariable("language") String language) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("airports");
        try {
            modelAndView.addObject("airports", clientBelaviaAirlines.getListOfAirports(language));
        } catch (IllegalArgumentException e) {
            modelAndView.addObject("airportIllegalExc", e.getMessage());
        } catch (SOAPException e) {
            modelAndView.addObject("airportSoapExc", e.getMessage());
        } catch (IOException e) {
            modelAndView.addObject("airportIoExc", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = {"/belavia/timetable"}, method = RequestMethod.GET)
    public ModelAndView getListOfFlights(@RequestParam("airport") String airport,
                                         @RequestParam("type") String type,
                                         @RequestParam("date") String date) throws IOException, SOAPException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("timetable");
        try {
            modelAndView.addObject("timetable", clientBelaviaAirlines.getListOfFlights(airport, type, date));
        } catch (IllegalArgumentException e) {
            modelAndView.addObject("timetableIllegalExc", e.getMessage());
        } catch (SOAPException e) {
            modelAndView.addObject("timetableSoapExc", e.getMessage());
        } catch (IOException e) {
            modelAndView.addObject("timetableIoExc", e.getMessage());
        }

        return modelAndView;
    }

    @RequestMapping(value = {"/globalweather/cities/{countryName}"}, method = RequestMethod.GET)
    public ModelAndView findCitiesByCountry(@PathVariable("countryName") String countryName) throws IOException, SOAPException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cities");
        modelAndView.addObject("cities", clientWeather.CitiesByCountry(countryName));

        return modelAndView;
    }

    @RequestMapping(value = {"/globalweather/weather/{countryName}/{cityName}"}, method = RequestMethod.GET)
    public ModelAndView findWeather(@PathVariable("countryName") String countryName,
                                    @PathVariable("cityName") String cityName) throws IOException, SOAPException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("weather");
        modelAndView.addObject("weather", clientWeather.Weather(countryName, cityName));

        return modelAndView;
    }
}
