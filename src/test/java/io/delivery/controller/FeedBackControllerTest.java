package io.delivery.controller;

import io.delivery.entity.FeedBack;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class FeedBackControllerTest {
    private final String ROOT = "http://localhost:8080/feedback";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";

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
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<FeedBack> list = result.getBody();
        assertNotNull(list.get(0));
    }

    @Test
    public void addFeedBack() throws Exception {
        createFeedback();
    }

    @Test
    public void updateFeedBack() throws Exception {
    }

    @Test
    public void deleteFeedBack() throws Exception {
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
        Assert.assertEquals(feedBack.getFeedBackText(), createdFeedBack.getFeedBackText());
        return createdFeedBack;
    }

    private FeedBack prefillFeedback() {
        FeedBack feedBack = new FeedBack();
        feedBack.setDate(LocalDateTime.now());
        feedBack.setFeedBackText("feedback for test");
        return feedBack;
    }

}