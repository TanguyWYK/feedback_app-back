package com.feedback.app.services;

import com.feedback.app.models.Feedback;
import com.feedback.app.models.Manager;
import com.feedback.app.repositories.FeedbackRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    public Iterable<Feedback> getFeedbackByMemberId(int id){
        return feedbackRepository.findByMemberId(id);
    }
    public Iterable<Feedback> getAllFeedbacks(){
        return feedbackRepository.findAll();
    }
}
