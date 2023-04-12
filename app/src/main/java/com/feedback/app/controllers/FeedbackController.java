package com.feedback.app.controllers;

import com.feedback.app.dto_in.FeedbackPostDTO;
import com.feedback.app.dto_out.FeedbackDTO;
import com.feedback.app.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping(value = "/feedbacks", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<FeedbackDTO>> getAllFeedbacks() {
        Iterable<FeedbackDTO> feedbackDTOS = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbackDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/feedbacks/manager/{managerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<FeedbackDTO>> getAllFeedbacksByManagerIdFromDateStartToDateEnd(
            @PathVariable String managerId, @RequestParam(name="start") String dateStart, @RequestParam(name="end") String dateEnd) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date1 = LocalDate.parse(dateStart, dateFormatter);
        LocalDate date2 = LocalDate.parse(dateEnd, dateFormatter);
        Iterable<FeedbackDTO> feedbackDTOS = feedbackService.getFeedbacksByManagerIdAndDateStartAndDateEnd(
                Integer.parseInt(managerId),
                date1,
                date2);
        return new ResponseEntity<>(feedbackDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/feedbacks/member/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<FeedbackDTO>> getFeedbacksByMemberId(@PathVariable String memberId) {
        Iterable<FeedbackDTO> feedbackDTOS = feedbackService.getFeedbacksByMemberId(Integer.parseInt(memberId));
        return new ResponseEntity<>(feedbackDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/feedback",produces = MediaType.APPLICATION_JSON_VALUE)
    FeedbackDTO postFeedback(FeedbackPostDTO feedbackPostDTO) {
        System.out.println(feedbackPostDTO);
        return feedbackService.createFeedback(feedbackPostDTO);
    }

}
