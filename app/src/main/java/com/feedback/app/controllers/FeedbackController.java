package com.feedback.app.controllers;

import com.feedback.app.dto_out.FeedbackDTO;
import com.feedback.app.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping(value = "/feedbacks",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<FeedbackDTO>> getAllFeedbacks() {
        Iterable<FeedbackDTO> feedbackDTOS = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbackDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/feedbacks/manager/{managerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<FeedbackDTO>> getAllFeedbacksByManagerId(@PathVariable String managerId) {
        Iterable<FeedbackDTO> feedbackDTOS = feedbackService.getFeedbacksByManagerId(Integer.parseInt(managerId));
        return new ResponseEntity<>(feedbackDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/feedbacks/member/{memberId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<FeedbackDTO>> getFeedbacksByMemberId(@PathVariable String memberId) {
        Iterable<FeedbackDTO> feedbackDTOS = feedbackService.getFeedbacksByMemberId(Integer.parseInt(memberId));
        return new ResponseEntity<>(feedbackDTOS, HttpStatus.OK);
    }

}
