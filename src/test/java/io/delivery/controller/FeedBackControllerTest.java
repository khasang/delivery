package io.delivery.controller;

import io.delivery.entity.FeedBack;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FeedBackControllerTest {
    private final String ROOT = "http://localhost:8080/feedback";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";

    @Test
    public void addFeedBack() throws Exception {
        createFeedback();
    }

    private FeedBack createFeedback() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        FeedBack feedBack = prefillFeedback();
        HttpEntity<FeedBack> httpEntity = new HttpEntity<>(feedBack, headers);
        RestTemplate restTemplate = new RestTemplate();
        FeedBack createdFeedBack = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                FeedBack.class
        ).getBody();
        assertNotNull(createdFeedBack);
        assertEquals(feedBack.getFeedBackText(), createdFeedBack.getFeedBackText());
        return createdFeedBack;
    }

    private FeedBack prefillFeedback() {
        FeedBack feedBack = new FeedBack();
        feedBack.setDate(new Date());
        feedBack.setFeedBackText("feedback for test");
        return feedBack;
    }

    @Test
    public void getAllFeedbacks() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        createFeedback();
        createFeedback();

        ResponseEntity<List<FeedBack>> result = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FeedBack>>() {
                }
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<FeedBack> list = result.getBody();
        assertNotNull(list.get(0));
    }

    @Test
    public void updateFeedBack() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        FeedBack feedBack = createFeedback();
        assertNotNull(feedBack);

        feedBack.setFeedBackText("TEST");

        HttpEntity<FeedBack> httpEntity = new HttpEntity<>(feedBack, headers);
        FeedBack resultUpdate = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                FeedBack.class
        ).getBody();

        assertNotNull(resultUpdate);
        assertNotNull(resultUpdate.getId());
        assertEquals("TEST", resultUpdate.getFeedBackText());
    }

    @Test
    public void deleteFeedBack() throws Exception {
        FeedBack feedBack = createFeedback();
        assertNotNull(feedBack);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                feedBack.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

}