package io.delivery.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Answer {
    private String infoAnswer;

    public Answer() {
    }

    public Answer(String infoAnswer) {
        this.infoAnswer = infoAnswer;
    }

    public String getInfoAnswer() {
        return infoAnswer;
    }

    public void setInfoAnswer(String infoAnswer) {
        this.infoAnswer = infoAnswer;
    }
}