package io.delivery.service.impl;

import io.delivery.dao.FeedBackDao;
import io.delivery.entity.FeedBack;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class FeedBackServiceImpTest {
    @Mock
    private FeedBackDao dao;

    @InjectMocks
    private FeedBackServiceImp feedbackService;

    @Spy
    private List<FeedBack> feedBacks = new ArrayList<>();

    @Captor
    private ArgumentCaptor<FeedBack> captor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        feedBacks = getFeedbacks();
    }

    private List<FeedBack> getFeedbacks() {
        FeedBack feedBack1 = new FeedBack("first");
        feedBack1.setId(1L);
        FeedBack feedBack2 = new FeedBack("second");
        feedBack2.setId(2L);
        FeedBack feedBack3 = new FeedBack("third");
        feedBack3.setId(3L);
        feedBacks.add(feedBack1);
        feedBacks.add(feedBack2);
        feedBacks.add(feedBack3);
        return feedBacks;
    }

    @After
    public void tearDown() throws Exception {
        feedBacks.clear();
    }

    @Test
    public void getFeedbackList() throws Exception {
        when(dao.getList()).thenReturn(feedBacks);
        Assert.assertEquals( feedBacks,feedbackService.getFeedbackList());
        verify(dao, times(1)).getList();

    }

    @Test
    public void create() throws Exception {
        FeedBack feedBack = feedBacks.get(0);
        when(dao.create(any(FeedBack.class))).thenReturn(feedBack);

        Assert.assertEquals(feedBack.getFeedBackText(), feedbackService.create(feedBack).getFeedBackText());

        verify(dao, times(1)).create(feedBack);
        Assert.assertEquals(3, feedBacks.size());
        verify(feedBacks, times(3)).add(any(FeedBack.class));
    }

    @Test
    public void updateFeedBack() throws Exception {
        FeedBack feedBack = feedBacks.get(0);
        when(dao.update(any(FeedBack.class))).thenReturn(feedBack);
        Assert.assertEquals(feedBack.getFeedBackText(), feedbackService.updateFeedBack(feedBack).getFeedBackText());
        verify(dao, times(1)).update(any(FeedBack.class));
    }

    @Test
    public void deleteFeedBack() throws Exception {
        FeedBack feedBack = feedBacks.get(0);
        when(dao.delete(any(FeedBack.class))).thenReturn(feedBack);
        Assert.assertEquals(feedBack.getFeedBackText(), feedbackService.deleteFeedBack(feedBack).getFeedBackText());
        verify(dao, times(1)).delete(any(FeedBack.class));
    }

    @Test
    public void findById() throws Exception {
        FeedBack feedBack = feedBacks.get(0);
        when(dao.findById(anyLong())).thenReturn(feedBack);
        Assert.assertEquals(feedBack.getId(),feedbackService.findById(feedBack.getId()).getId());
        verify(dao, times(1)).findById(anyLong());
    }

}