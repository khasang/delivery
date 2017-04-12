package io.khassang.document;

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
    private final String ADD = "/add/";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/";
    private final String GET_NAME = "/get/name/";
    private final String ALL = "/all";

    @Test
    public void addDocumentAndGet(){
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

    private Document createDocument(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Document document = prefillDocument();
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
        RestTemplate restTemplate = new RestTemplate();
        Document createdDocument = restTemplate.exchange(
                ROOT+ADD,
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
        document.setName("documentForTest");
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

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> result = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                document.getId()
        );

        assertEquals(HttpStatus.OK, result.getStatusCode());

        ResponseEntity<Document> checkDocumentById = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Document.class,
                document.getId()
        );

        assertEquals(HttpStatus.OK, checkDocumentById.getStatusCode());
        assertNull(checkDocumentById.getBody());
    }

    @Test
    public void updateDocument(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Document document = createDocument();
        document.setName("newTestDocument");
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> result = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Document.class
        );

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        Document newDocument = result.getBody();
        assertEquals("newTestDocument", newDocument.getName());

    }

    @Test
    public void getDocumentByName() {
        Document document = createDocument();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Document>> responseEntity = restTemplate.exchange(
                ROOT + GET_NAME + "{name}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Document>>() {},
                document.getName()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        List<Document> list = responseEntity.getBody();
        assertNotNull(list);
        assertNotNull(list.get(0));
    }
}
