package io.delivery.document;

import io.delivery.config.AppConfig;
import io.delivery.config.HibernateConfig;
import io.delivery.entity.Document;
import io.delivery.service.DocumentService;
import io.delivery.service.impl.DocumentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DocumentServiceImpl.class, HibernateConfig.class})
public class DocumentIntegrationTest {
    private final String ROOT = "http://localhost:8080/document";
    private final String GET_ID = "/get/id/";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";
    private final String GET_NAME = "/get/name/";

    @Autowired
    private DocumentService documentService;

    private Document createDocument() {
        Document document = new Document();
        document.setName("Magic");
        document.setSpecificInnerInfo("fire");
        documentService.create(document);
        return document;
    }

    @Test
    public void addDocument() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Document document = new Document();
        document.setName("Magic");
        document.setSpecificInnerInfo("fire");
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Document.class
        );
        Document createdDocument = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(createdDocument);
        assertEquals(createdDocument.getName(), createdDocument.getName());
        documentService.deleteDocument(createdDocument.getId());
    }

    @Test
    public void getDocumentById() {
        Document createdDocument = createDocument();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Document.class,
                createdDocument.getId()
        );

        Document resultDocument = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(resultDocument);
        assertEquals(createdDocument.getName(), resultDocument.getName());
        documentService.deleteDocument(createdDocument.getId());
    }

    @Test
    public void getDocumentByName() {
        Document createdDocument = createDocument();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Document>> result = restTemplate.exchange(
                ROOT + GET_NAME + "{name}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Document>>() {
                },
                createdDocument.getName()
        );

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<Document> list = result.getBody();
        assertNotNull(list.get(0));
        documentService.deleteDocument(createdDocument.getId());
    }

    @Test
    public void getAllDocuments(){
        Document createdDocument = createDocument();

        RestTemplate restTemplate = new RestTemplate();

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
        documentService.deleteDocument(createdDocument.getId());
    }

   @Test
    public void updateDocument() {
        Document createdDocument = createDocument();
        createdDocument.setName("Sword");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Document> httpEntity = new HttpEntity<>(createdDocument, headers);
        ResponseEntity<Document> responseEntity = restTemplate.exchange(
               ROOT + UPDATE,
               HttpMethod.PUT,
               httpEntity,
               Document.class
        );
        Document updatedDocument = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(updatedDocument);
        assertEquals(updatedDocument.getName(), createdDocument.getName());
        documentService.deleteDocument(createdDocument.getId());
    }

    @Test
    public void deleteDocument(){
        Document createdDocument = createDocument();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                createdDocument.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<Document> checkDocumentById = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Document.class,
                createdDocument.getId()
        );

        assertEquals(HttpStatus.OK, checkDocumentById.getStatusCode());
        assertNull(checkDocumentById.getBody());
    }
}
