package io.delivery.controller;

import io.delivery.dto.FeedBackDto;
import io.delivery.entity.FeedBack;
import io.delivery.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ModelAndView getAllFeedbacks() {
        ModelAndView modelAndView = new ModelAndView("feedback", "feedbackDto", new FeedBackDto());
        modelAndView.addObject("feedbacks", feedbackService.getFeedbackList());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addFeedBack(@ModelAttribute("feedbackDto") FeedBackDto feedBackDto) {
        FeedBack feedBack = new FeedBack(LocalDateTime.now(), feedBackDto.getText());
        feedbackService.create(feedBack);
        return new ModelAndView("redirect:" + "/feedback");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteFeedBack(WebRequest request) {
        Long feedbackId = Long.parseLong(request.getParameter("feedbackId"));
        feedbackService.deleteFeedBack(feedbackId);
        return new ModelAndView("redirect:" + "/feedback");
    }
}
