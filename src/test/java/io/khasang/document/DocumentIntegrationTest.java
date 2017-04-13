package io.khasang.document;

import io.delivery.entity.Document;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class DocumentIntegrationTest {
    private final String ROOT = "http://localhost:8080/document";
    private final String GET_ID = "/get/id/";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";
    private final String GET_NAME = "/get/name/";

    @Test
    public void addDocumentAndGet() {
        Document document = createDocument();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Document.class,
                document.getId()
        );

        Document resultDocument = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(resultDocument);
    }

    private Document createDocument() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Document document = prefillDocument();
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
        RestTemplate restTemplate = new RestTemplate();
        Document createdDocument = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Document.class
        ).getBody();
        assertNotNull(createdDocument);
        assertEquals(document.getName(), createdDocument.getName());
        return createdDocument;
    }

    private Document prefillDocument() {
        Document document = new Document();
        document.setName("Magic");
        document.setSpecificInnerInfo("fire");
        return document;
    }

    @Test
    public void getAllDocuments(){
        RestTemplate restTemplate = new RestTemplate();
        createDocument();
        createDocument();

        ResponseEntity<List<Document>> result = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Document>>() {
                }
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<Document> list = result.getBody();
        assertNotNull(list.get(0));
    }

    @Test
    public void deleteDocument(){
        Document document = createDocument();
        assertNotNull(document);  // проверяем документ на 0

        RestTemplate restTemplate = new RestTemplate();   // для работы с REST-сервисами
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",  // корневой путь, куда делается запрос
                HttpMethod.DELETE,   // тип запроса
                null,  // передаём тело запроса (0 т.к. ID)
                String.class,  // к чему должны привести ответ (работаем как с классом Стринга)
                document.getId() // доп параметр (кидаем в документ Id - изменчивая часть)
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());  // сравниваем статус с ответом

        ResponseEntity<Document> checkDocumentById = restTemplate.exchange(   // проверка что  документа с таким Id НЕ СУЩЕСТВУЕТ !  (checkDocumentById)
                ROOT + GET_ID + "{id}",  // корневой путь, куда делается запрос
                HttpMethod.GET,  // тип запроса
                null,  // передаём тело запроса (0 т.к. ID)
                Document.class,  // к чему должны привести ответ (работаем как с классом Стринга)
                document.getId()  // доп параметр (кидаем в документ Id - изменчивая часть)
        );

        assertEquals(HttpStatus.OK, checkDocumentById.getStatusCode());  // сравниваем статус с Документом на рповерку Id
        assertNull(checkDocumentById.getBody());  // проверка на 0 (наш документ который мы проверяем на не существующий Id)
    }

    @Test
    public void updateDocument(){
        HttpHeaders headers = new HttpHeaders();   // для типа запроса (Content-Type)
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);  // тип запроса APPLICATION_JSON_UTF8

        RestTemplate restTemplate = new RestTemplate();  // для работы с REST сервисами
        Document document = createDocument();
        assertNotNull(document);  // проверка на создание документа (не равен 0)

        document.setName("Sword");

        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
        Document resultUpdate = restTemplate.exchange(   // создаём наш документ resultUpdate
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Document.class
        ).getBody();

        assertNotNull(resultUpdate);  // проверка на 0 нашего документа resultUpdate
        assertNotNull(resultUpdate.getId());  // проверка на 0 по Id нашего документа resultUpdate
        assertEquals("Sword", resultUpdate.getName());  // проверка, что "Sword" должен соответствовать имени нашего документа resultUpdate
    }
}
