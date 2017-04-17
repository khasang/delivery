package io.delivery.controller;

import io.delivery.entity.Document;
import io.delivery.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import java.util.List;

/**
 * Created by NortT on 15.04.2017.
 */
@Controller
@RequestMapping ("/document")
public class DocumentController {
    final private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping (value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocumentList(Model model) {
        model.addAttribute("status", documentService.getDocumentList());
        return documentService.getDocumentList();
    }

    @RequestMapping (value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocumentByName(@PathVariable (value = "name") String name,  Model model) {
        model.addAttribute("status", documentService.getDocumentList());
        return documentService.findByName(name);
    }

    @RequestMapping (value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Document addDocument(@RequestBody Document document,  Model model) {
        Document document1 = documentService.create(document);
        model.addAttribute("status", document1);
        return document1;
    }

    @RequestMapping (value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Document updateDocument(@RequestBody Document document) {
        documentService.update(document);
        return document;
    }


    @RequestMapping (value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Document deleteDocument(@PathVariable (value = "id") String id) {
        return documentService.delete(Long.parseLong(id));
    }

    @RequestMapping (value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Document getDocumentById(@PathVariable (value = "id") String id,  Model model) {
        //model.addAttribute("status", documentService.getDocumentList());
        return documentService.findById(Long.parseLong(id));
    }
}
