package io.delivery.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private Long userId;
    @Column(name = "feedback_date")
    private LocalDateTime date;
    @Column(name = "feedback_text")
    private String feedBackText;

    public FeedBack() {
    }

    public FeedBack(LocalDateTime date, String feedBackText) {
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getFeedBackText() {
        return feedBackText;
    }

    public void setFeedBackText(String feedBackText) {
        this.feedBackText = feedBackText;
    }
}
