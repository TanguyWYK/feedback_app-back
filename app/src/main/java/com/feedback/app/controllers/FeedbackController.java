package com.feedback.app.controllers;

import com.feedback.app.models.Feedback;
import com.feedback.app.models.Manager;
import com.feedback.app.services.FeedbackService;
import com.feedback.app.utilities.UsingJson;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@Data
@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping(value = "/feedbacks",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getAllFeedbacks() throws InvocationTargetException, IllegalAccessException {
        Iterable<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbacks.toString(), HttpStatus.OK);
    }

    @GetMapping(value = "/feedbacks/{memberId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getFeedbackByMemberId(@PathVariable String memberId) throws InvocationTargetException, IllegalAccessException {
        Iterable<Feedback> feedbacks = feedbackService.getFeedbackByMemberId(Integer.parseInt(memberId));
        return new ResponseEntity<>(feedbacks.toString(), HttpStatus.OK);
    }

    private ArrayList<UsingJson> buildJsonArray(Iterable<Feedback> feedbacks) throws InvocationTargetException, IllegalAccessException {
        var feedbacksOut = new ArrayList<UsingJson>();
        for (Feedback feedback: feedbacks) {
            var json = new UsingJson(feedback);
            feedbacksOut.add(json);
        }
        return feedbacksOut;
    }

}
