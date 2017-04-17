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
    public void addDocumentAndGetById() {
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
    public void getAllDocument() {
        RestTemplate restTemplate = new RestTemplate();
        createDocument();
        createDocument();

        ResponseEntity<List<Document>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Document>>() {
                }
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        List<Document> list = responseEntity.getBody();
        assertNotNull(list.get(0));
    }

    @Test
    public void deleteDocument() {
        Document document = createDocument();
        assertNotNull(document);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                document.getId()
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

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
    public void updateDocument() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        Document document = createDocument();
        assertNotNull(document);

        document.setName("Sword");

        HttpEntity<Document> httpEntity = new HttpEntity<>(document, httpHeaders);
        Document resultUpdate = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Document.class
        ).getBody();

        assertNotNull(resultUpdate);
        assertNotNull(resultUpdate.getId());
        assertEquals("Sword", resultUpdate.getName());
    }

    @Test
    public void addDocumentAndGetByName() {
        Document document = createDocument();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Document>> responseEntity = restTemplate.exchange(
                ROOT + GET_NAME + "{name}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Document>>() {
                },
                document.getName()
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        List<Document> list = responseEntity.getBody();
        assertEquals(document.getName(), list.get(0).getName());
    }

}
