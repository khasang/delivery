package io.delivery.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedbacks")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private Long userId;
    @Column(name = "feedback_date")
    private Date date;
    @Column(name = "feedback_text")
    private String feedBackText;

    public FeedBack() {
    }

    public FeedBack(String feedBackText) {
        this.date = new Date();
        this.feedBackText = feedBackText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFeedBackText() {
        return feedBackText;
    }

    public void setFeedBackText(String feedBackText) {
        this.feedBackText = feedBackText;
    }
}
