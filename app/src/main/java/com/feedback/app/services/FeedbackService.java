package com.feedback.app.services;

import com.feedback.app.dto_in.FeedbackPostDTO;
import com.feedback.app.dto_out.FeedbackDTO;
import com.feedback.app.models.Criterion;
import com.feedback.app.models.Feedback;
import com.feedback.app.models.Member;
import com.feedback.app.repositories.FeedbackRepository;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private CriterionService criterionService;

    public Iterable<FeedbackDTO> getFeedbacksByMemberId(int id) {
        Iterable<Feedback> feedbacks = feedbackRepository.findByMemberId(id);
        return buildDTOsFromEntity(feedbacks);
    }

    public Iterable<FeedbackDTO> getFeedbacksByManagerIdAndDateStartAndDateEnd(int id, LocalDate dateStart, LocalDate dateEnd) {
        Iterable<Feedback> feedbacks = feedbackRepository.findAllByDateBetweenAndMember_ManagerId(dateStart,dateEnd,id);
        return buildDTOsFromEntity(feedbacks);
    }


    public Iterable<FeedbackDTO> getAllFeedbacks() {
        Iterable<Feedback> feedbacks = feedbackRepository.findAll();
        return buildDTOsFromEntity(feedbacks);
    }

    public FeedbackDTO createFeedback(FeedbackPostDTO feedbackPostDTO){

        Feedback feedback = new Feedback();
        Criterion criterion = new Criterion(feedbackPostDTO.getCriterionId(),feedbackPostDTO.getManagerId());
        Member member = new Member(feedbackPostDTO.getMemberId(),feedbackPostDTO.getManagerId());
        feedback.setCriterion(criterion);
        feedback.setMember(member);
        feedback.setValue(feedbackPostDTO.getValue());
        Feedback feedbackAdded = feedbackRepository.save(feedback);
        return buildDTOFromEntity(feedbackAdded);
    }

    private Iterable<FeedbackDTO> buildDTOsFromEntity(Iterable<Feedback> feedbacks) {
        ArrayList<FeedbackDTO> feedbackDTOS = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            feedbackDTOS.add(buildDTOFromEntity(feedback));
        }
        return feedbackDTOS;
    }

    private FeedbackDTO buildDTOFromEntity(Feedback feedback){
        ModelMapper modelMapper = new ModelMapper();
        FeedbackDTO feedbackDTO = modelMapper.map(feedback, FeedbackDTO.class);
        feedbackDTO.setMemberEmail(feedback.getMember().getEmail());
        feedbackDTO.setManagerEmailThisMonth(feedback.getManagerThisMonth().getEmail());
        return feedbackDTO;
    }


}
