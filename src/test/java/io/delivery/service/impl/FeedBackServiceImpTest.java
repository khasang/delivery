package io.delivery.service.impl;

import io.delivery.config.HibernateConfig;
import io.delivery.config.application.WebConfig;
import io.delivery.entity.FeedBack;
import io.delivery.service.FeedbackService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
@WebAppConfiguration
public class FeedBackServiceImpTest {
    @Autowired
    private FeedbackService feedbackService;

    private FeedBack feedBack;

    @Before
    public void setUp() throws Exception {
        feedBack = new FeedBack(LocalDateTime.now(), "feedback");
        feedbackService.create(feedBack);
    }

    @After
    public void tearDown() throws Exception {
        Long id = feedBack.getId();
        FeedBack feedBackById = feedbackService.findById(id);
        if (feedBackById != null) {
            feedbackService.deleteFeedBack(id);
        }
    }

    @Test
    public void getFeedbackList() throws Exception {
        List<FeedBack> feedbackList = feedbackService.getFeedbackList();
        Assert.assertNotNull(feedbackList);
        Assert.assertEquals(2, feedbackList.size());
    }

    @Test
    public void findById() throws Exception {
        Long feedBackId = feedBack.getId();
        Assert.assertNotNull(feedBackId);
        FeedBack reloadFeedBack = feedbackService.findById(feedBackId);
        Assert.assertEquals(feedBack.getFeedBackText(), reloadFeedBack.getFeedBackText());
    }

    @Test
    public void create() throws Exception {
    }


    @Test
    public void updateFeedBack() throws Exception {
    }

    @Test
    public void deleteFeedBack() throws Exception {
    }

}