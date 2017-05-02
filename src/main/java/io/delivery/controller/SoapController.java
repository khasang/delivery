package io.delivery.controller;

import io.delivery.by.belavia.webservices.ClientBelaviaAirlines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.soap.SOAPException;
import java.io.IOException;

@Controller
@RequestMapping("/soap") // При добавлении дополнительных soap-сервисов тут можно будет указать /soap
public class SoapController {
    final private ClientBelaviaAirlines clientBelaviaAirlines;

    @Autowired
    public SoapController(ClientBelaviaAirlines clientBelaviaAirlines){
        this.clientBelaviaAirlines = clientBelaviaAirlines;
    }

            // Соответственно если вверху /soap то тут добавить - /belavia
    @RequestMapping(value = {"/belavia/airports/{language}"}, method = RequestMethod.GET)
    public ModelAndView getAirportsList(@PathVariable("language") String language){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("airports");
        try {
            modelAndView.addObject("airports", clientBelaviaAirlines.getListOfAirports(language));
        }catch (IllegalArgumentException e){
            modelAndView.addObject("airportIllegalExc", e.getMessage());
        }catch (SOAPException e){
            modelAndView.addObject("airportSoapExc", e.getMessage());
        }catch (IOException e){
            modelAndView.addObject("airportIoExc", e.getMessage());
        }
        return modelAndView;
    }

            // Соответственно если вверху /soap то тут добавить - /belavia
    @RequestMapping(value = {"/belavia/timetable/{airport}/{type}/{date}"}, method = RequestMethod.GET)
    public ModelAndView getListOfFlights(@PathVariable("airport") String airport,
                                         @PathVariable("type") String type,
                                         @PathVariable("date") String date) throws IOException, SOAPException {
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
}
