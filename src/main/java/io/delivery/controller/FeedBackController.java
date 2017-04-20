package io.delivery.controller;

import io.delivery.entity.FeedBack;
import io.delivery.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<FeedBack> getAllFeedbacks() {
        return feedbackService.getFeedbackList();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public FeedBack addFeedBack(@RequestBody FeedBack feedBack) {
        feedbackService.create(feedBack);
        return feedBack;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public FeedBack updateFeedBack(@RequestBody FeedBack feedBack) {
        feedbackService.updateFeedBack(feedBack);
        return feedBack;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public FeedBack deleteFeedBack(@PathVariable(value = "id") String inputId) {
        FeedBack foundFeedback = feedbackService.findById(Long.parseLong(inputId));
        return feedbackService.deleteFeedBack(foundFeedback);
    }
}
