package io.delivery.document;

import io.delivery.entity.Document;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by NortT on 15.04.2017.
 */
public class DocumentIntegrationTest {
    private final String ROOT = "http://localhost:8080/document";
    private final String GET_ID = "/get/id/";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";
    private final String GET_NAME = "/get/name/";

    @Test
    public void addDocument() {
        Document document = createDocument();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                ROOT+GET_ID+"{id}",
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
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Document document = prefillDocument();
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, httpHeaders);
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
    public void getAllDocuments() {
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
        List<Document> documentList = result.getBody();
        assertNotNull(documentList.get(0));
    }

    @Test
    public void deleteDocument() {
        RestTemplate restTemplate = new RestTemplate();
        Document document = createDocument();
        assertNotNull(document);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT+DELETE+"{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                document.getId()
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<Document> deletedDocument = restTemplate.exchange(
                ROOT+GET_ID+"{id}",
                HttpMethod.GET,
                null,
                Document.class,
                document.getId()
        );

        assertEquals(HttpStatus.OK, deletedDocument.getStatusCode());
        assertNull(deletedDocument.getBody());
    }

    @Test
    public void updateDocument(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        Document document = createDocument();
        assertNotNull(document);

        document.setName("Sword");

        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
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
}
