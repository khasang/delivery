package io.delivery.controller;

import io.delivery.entity.Office;
import io.delivery.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/office")
public class OfficeController {
    final private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Office addOffice(@RequestBody Office office) {
        return officeService.create(office);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Office deleteOffice(@PathVariable(value = "id") String id) {
        return officeService.delete(Long.parseLong(id));
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Office> getOfficeList(){
        return officeService.getOfficeList();
    }
}
