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
    public List<Document> getDocumentList () {
        return documentService.getDocumentList();
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocumentByName (@PathVariable(value = "name") String name) {
        return documentService.findByName(name);
    }

// При попытке обратиться по адресу document/add в пост формате в контент тайпе аппликейшн джейсон (кодировка), он будет парсить наш запрос  соответственно с телом документа, искать там 3 параметра (id, name, specificInnerInfo), с которыми мы работаем, с тем исключением, что на уровне Document у нас id генерируется автоматом, (его можем не передавать в принципе), он их спарсит в структуру java нашего документа из application/json, кинет всё это дальше на сервис, слой сервис перейдт на ДАО слой, ДАО слой переправит это во внутрь нашей таблицы. Если всё ок то он это всё создаст.
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody  // тело, чтобы мы могли видеть ответ
    public Document addDocument(@RequestBody Document document) {
        documentService.create(document);
        return document;
    }


}
