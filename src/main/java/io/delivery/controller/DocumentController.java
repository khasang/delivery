package io.delivery.controller;

import io.delivery.entity.Document;
import io.delivery.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {

    final private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
<<<<<<< HEAD
    public List<Document> getDocumentList() {
        return documentService.getDocumentList();
    }
    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocumentByName(@PathVariable(value = "name") String name) {
=======
    public List<Document> getDocumentList(){
        return documentService.getDocumentList();
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocumentByName(@PathVariable(value = "name") String name){
>>>>>>> origin/feedback
        return documentService.findByName(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
<<<<<<< HEAD
    public Document addDocument(@RequestBody Document document) {
=======
    public Document addDocument(@RequestBody Document document){
>>>>>>> origin/feedback
        documentService.create(document);
        return document;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
<<<<<<< HEAD
    public Document updateDocument(@RequestBody Document document) {
=======
    public Document updateDocument(@RequestBody Document document){
>>>>>>> origin/feedback
        documentService.updateDocument(document);
        return document;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
<<<<<<< HEAD
    public Document deleteDocument(@PathVariable(value = "id") String inputId) {

=======
    public Document deleteDocument(@PathVariable(value = "id") String inputId){
>>>>>>> origin/feedback
        return documentService.deleteDocument(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
<<<<<<< HEAD
    public Document getDocumentById(@PathVariable(value = "id") String id) {

=======
    public Document getDocumentById(@PathVariable(value = "id") String id){
>>>>>>> origin/feedback
        return documentService.findById(Long.parseLong(id));
    }
}
