package com.feedback.app.controllers;

import com.feedback.app.dto_out.FeedbackDTO;
import com.feedback.app.models.Feedback;
import com.feedback.app.models.Manager;
import com.feedback.app.services.FeedbackService;
import com.feedback.app.utilities.UsingJson;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping(value = "/feedbacks",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<FeedbackDTO>> getAllFeedbacks() {
        Iterable<FeedbackDTO> feedbackDTOS = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbackDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/feedbacks/{memberId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<FeedbackDTO>> getFeedbackByMemberId(@PathVariable String memberId) {
        Iterable<FeedbackDTO> feedbackDTOS = feedbackService.getFeedbackByMemberId(Integer.parseInt(memberId));
        return new ResponseEntity<>(feedbackDTOS, HttpStatus.OK);
    }

}
