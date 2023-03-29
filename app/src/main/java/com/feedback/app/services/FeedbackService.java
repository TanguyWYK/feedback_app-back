package com.feedback.app.services;

import com.feedback.app.dto_out.CriterionDTO;
import com.feedback.app.dto_out.FeedbackDTO;
import com.feedback.app.models.Criterion;
import com.feedback.app.models.Feedback;
import com.feedback.app.repositories.CriterionRepository;
import com.feedback.app.repositories.FeedbackRepository;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Getter
@Setter
@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CriterionService criterionService;

    public Iterable<FeedbackDTO> getFeedbackByMemberId(int id) {
        Iterable<Feedback> feedbacks = feedbackRepository.findByMemberId(id);
        return buildDTOFromEntity(feedbacks);
    }

    public Iterable<FeedbackDTO> getAllFeedbacks() {
        Iterable<Feedback> feedbacks = feedbackRepository.findAll();
        return buildDTOFromEntity(feedbacks);
    }

    private Iterable<FeedbackDTO> buildDTOFromEntity(Iterable<Feedback> feedbacks) {
        ArrayList<FeedbackDTO> feedbackDTOS = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            ModelMapper modelMapper = new ModelMapper();
            FeedbackDTO feedbackDTO = modelMapper.map(feedback, FeedbackDTO.class);
            feedbackDTO.setCriterionName(feedback.getCriterion().getName());
            feedbackDTO.setMemberEmail(feedback.getMember().getEmail());
            feedbackDTOS.add(feedbackDTO);
        }
        return feedbackDTOS;
    }
}
