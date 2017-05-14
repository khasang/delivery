package io.delivery.document;

import io.delivery.entity.Document;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
<<<<<<< HEAD
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

=======
import org.springframework.web.client.RestTemplate;
>>>>>>> origin/feedback
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
<<<<<<< HEAD

=======
import static org.junit.Assert.assertNull;

/**
 * Created by NortT on 15.04.2017.
 */
>>>>>>> origin/feedback
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
<<<<<<< HEAD
        Document document = createDocumet();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
=======
        Document document = createDocument();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                ROOT+GET_ID+"{id}",
>>>>>>> origin/feedback
                HttpMethod.GET,
                null,
                Document.class,
                document.getId()
<<<<<<< HEAD

        );
=======
        );

>>>>>>> origin/feedback
        Document resultDocument = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(resultDocument);
    }

<<<<<<< HEAD
    private Document createDocumet() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Document document = prefillDocument();
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
        RestTemplate restTemplate = new RestTemplate();
        Document createDocument = restTemplate.exchange(
=======
    private Document createDocument() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Document document = prefillDocument();
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Document createdDocument = restTemplate.exchange(
>>>>>>> origin/feedback
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Document.class
<<<<<<< HEAD
        ).getBody();
        assertNotNull(createDocument);
        assertEquals(document.getName(), createDocument.getName());
        return createDocument;
=======
                ).getBody();

        assertNotNull(createdDocument);
        assertEquals(document.getName(), createdDocument.getName());

        return createdDocument;
>>>>>>> origin/feedback
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
<<<<<<< HEAD
        createDocumet();
        createDocumet();
=======
        createDocument();
        createDocument();
>>>>>>> origin/feedback

        ResponseEntity<List<Document>> result = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Document>>() {
                }
        );
<<<<<<< HEAD

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<Document> list = result.getBody();
        assertNotNull(list.get(0));
    }

    @Test
    public void deleteDocument(){
        Document document = createDocumet();
        assertNotNull(document);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
=======
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
>>>>>>> origin/feedback
                HttpMethod.DELETE,
                null,
                String.class,
                document.getId()
        );
<<<<<<< HEAD

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ResponseEntity<Document> checkDocumentById = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
=======
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<Document> deletedDocument = restTemplate.exchange(
                ROOT+GET_ID+"{id}",
>>>>>>> origin/feedback
                HttpMethod.GET,
                null,
                Document.class,
                document.getId()
        );
<<<<<<< HEAD
        assertEquals(HttpStatus.OK, checkDocumentById.getStatusCode());
        assertNotNull(checkDocumentById.getBody());

    }

    @Test
    public void updateDocument() {
=======

        assertEquals(HttpStatus.OK, deletedDocument.getStatusCode());
        assertNull(deletedDocument.getBody());
    }

    @Test
    public void updateDocument(){
>>>>>>> origin/feedback
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
<<<<<<< HEAD
        Document document = createDocumet();
=======
        Document document = createDocument();
>>>>>>> origin/feedback
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
<<<<<<< HEAD

=======
>>>>>>> origin/feedback
}
