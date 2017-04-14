package io.delivery.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "feedbacks")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private Long userId;
    @Column(name = "feedback_date")
    private LocalDate date;
    @Column(name = "feedback_text")
    private String feedBackText;

    public FeedBack() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFeedBackText() {
        return feedBackText;
    }

    public void setFeedBackText(String feedBackText) {
        this.feedBackText = feedBackText;
    }

    public FeedBack(LocalDate date, String feedBackText) {
        this.date = date;
        this.feedBackText = feedBackText;
    }
}
