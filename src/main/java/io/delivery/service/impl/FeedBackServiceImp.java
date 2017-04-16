package io.delivery.service.impl;

import io.delivery.dao.FeedBackDao;
import io.delivery.entity.FeedBack;
import io.delivery.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("feedBackService")
public class FeedBackServiceImp implements FeedbackService {
    @Autowired
    private FeedBackDao feedbackDao;
    @Override
    public List<FeedBack> getFeedbackList() {
        return feedbackDao.getList();
    }

    @Override
    public FeedBack create(FeedBack feedBack) {
        return feedbackDao.create(feedBack);
    }

    @Override
    public FeedBack updateFeedBack(FeedBack feedBack) {
        return feedbackDao.update(feedBack);
    }

    @Override
    public FeedBack deleteFeedBack(long id) {
        return feedbackDao.delete(findById(id));
    }

    @Override
    public FeedBack findById(long id) {
        return feedbackDao.findById(id);
    }
}
