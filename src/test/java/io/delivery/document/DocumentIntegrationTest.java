package io.delivery.document;

import io.delivery.entity.Document;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        Document document = createDocumet();
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

    private Document createDocumet() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Document document = prefillDocument();
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
        RestTemplate restTemplate = new RestTemplate();
        Document createDocument = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Document.class
        ).getBody();
        assertNotNull(createDocument);
        assertEquals(document.getName(), createDocument.getName());
        return createDocument;
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
        createDocumet();
        createDocumet();

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
        Document document = createDocumet();
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
        assertNotNull(checkDocumentById.getBody());

    }

    @Test
    public void updateDocument() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        Document document = createDocumet();
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
