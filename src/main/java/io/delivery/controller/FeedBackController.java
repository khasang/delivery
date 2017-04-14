package io.delivery.controller;

import io.delivery.dto.FeedBackDto;
import io.delivery.entity.FeedBack;
import io.delivery.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllFeedbacks() {
        ModelAndView modelAndView = new ModelAndView("feedback", "feedbackDto", new FeedBackDto());
        modelAndView.addObject("feedbacks", feedbackService.getFeedbackList());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addFeedBack(@ModelAttribute("feedbackDto") FeedBackDto feedBackDto) {
        FeedBack feedBack = new FeedBack(LocalDate.now(), feedBackDto.getText());
        feedbackService.create(feedBack);
        return new ModelAndView("redirect:" + "/feedback");
    }
}
