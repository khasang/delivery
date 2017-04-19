package io.delivery.service;

import io.delivery.entity.FeedBack;

import java.util.List;

public interface FeedbackService {
    /**
     * Receive all documents from db
     *
     * @return document list
     */
    List<FeedBack> getFeedbackList();

    /**
     * Create feedBack at database
     *
     * @param feedBack - current document for creation
     * @return created feedBack
     */
    FeedBack create(FeedBack feedBack);

    /**
     * @param feedBack - document for update
     * @return document
     */
    FeedBack updateFeedBack(FeedBack feedBack);

    /**
     * @param feedBack = feedBack for delete
     * @return deleted feedBack
     */
    FeedBack deleteFeedBack(FeedBack feedBack);

    FeedBack findById(long id);
}
