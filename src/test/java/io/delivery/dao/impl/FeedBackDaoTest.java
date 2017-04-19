package io.delivery.dao.impl;

import io.delivery.config.HibernateConfig;
import io.delivery.config.application.WebConfig;
import io.delivery.dao.FeedBackDao;
import io.delivery.entity.FeedBack;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
@WebAppConfiguration
public class FeedBackDaoTest {
    @Autowired
    private FeedBackDao feedBackDao;

    private FeedBack feedBack;

    @Before
    public void setUp() throws Exception {
        feedBack = new FeedBack("feedback");
        feedBackDao.create(feedBack);
    }

    @After
    public void tearDown() throws Exception {
        Long id = feedBack.getId();
        FeedBack feedBackById = feedBackDao.findById(id);
        if (feedBackById != null) {
            feedBackDao.delete(feedBackById);
        }
    }

    @Test
    public void getFeedbackList() throws Exception {
        List<FeedBack> feedbackList = feedBackDao.getList();
        Assert.assertNotNull(feedbackList);
    }

    @Test
    public void findById() throws Exception {
        Long feedBackId = feedBack.getId();
        Assert.assertNotNull(feedBackId);
        FeedBack reloadFeedBack = feedBackDao.findById(feedBackId);
        Assert.assertEquals(feedBack.getFeedBackText(), reloadFeedBack.getFeedBackText());
    }

    @Test
    public void create() throws Exception {
        FeedBack createFeedBack = feedBackDao.create(feedBack);
        Assert.assertNotNull(createFeedBack);
    }


    @Test
    public void updateFeedBack() throws Exception {
        FeedBack oldFeedback = feedBackDao.findById(feedBack.getId());
        feedBack.setFeedBackText("new text");
        feedBackDao.update(feedBack);
        FeedBack reloadFeedback = feedBackDao.findById(feedBack.getId());
        Assert.assertNotNull(reloadFeedback);
        Assert.assertNotNull(feedBack);
        Assert.assertNotEquals(oldFeedback.getFeedBackText(), feedBack.getFeedBackText());
    }

    @Test
    public void deleteFeedBack() throws Exception {
        feedBackDao.delete(feedBack);
        Assert.assertNull(feedBackDao.findById(feedBack.getId()));
    }
}
