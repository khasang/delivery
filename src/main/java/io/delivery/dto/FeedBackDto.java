package io.delivery.dto;

public class FeedBackDto {
    private String text;

    public FeedBackDto() {
    }

    public FeedBackDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
