package com.feedback.app.services;

import com.feedback.app.dto_in.FeedbackPatchDTO;
import com.feedback.app.dto_in.FeedbackPostDTO;
import com.feedback.app.dto_out.FeedbackDTO;
import com.feedback.app.models.Criterion;
import com.feedback.app.models.Feedback;
import com.feedback.app.models.Manager;
import com.feedback.app.models.Member;
import com.feedback.app.repositories.CriterionRepository;
import com.feedback.app.repositories.FeedbackRepository;
import com.feedback.app.repositories.ManagerRepository;
import com.feedback.app.repositories.MemberRepository;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private CriterionRepository criterionRepository;

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

    public FeedbackDTO getFeedbackById(int id) {
        Optional<Feedback> feedback = feedbackRepository.findById(id);
        return buildDTOFromEntity(feedback.get());
    }

    public FeedbackDTO createFeedback(FeedbackPostDTO feedbackPostDTO){
        Feedback feedback = new Feedback();
        Optional<Criterion> criterion = criterionRepository.findById(feedbackPostDTO.getCriterionId());
        Optional<Member> member = memberRepository.findById(feedbackPostDTO.getMemberId());
        Optional<Manager> manager = managerRepository.findById(feedbackPostDTO.getManagerId());
        if(criterion.isPresent() && member.isPresent() && manager.isPresent()) {
            feedback.setCriterion(criterion.get());
            feedback.setMember(member.get());
            feedback.setManagerThisMonth(manager.get());
            feedback.setValue(feedbackPostDTO.getValue());
            feedback.setDate(feedbackPostDTO.getDate());
            Feedback feedbackAdded = feedbackRepository.save(feedback);
            return buildDTOFromEntity(feedbackAdded);
        }
        return null;
    }

    public FeedbackDTO updateFeedback(FeedbackPatchDTO feedbackPatchDTO){
        Optional<Feedback> feedback = feedbackRepository.findById(feedbackPatchDTO.getId());
        if(feedback.isPresent()){
            Feedback feedbackToUpdate = feedback.get();
            feedbackToUpdate.setValue(feedbackPatchDTO.getValue());
            Feedback feedbackAdded = feedbackRepository.save(feedbackToUpdate);
            return buildDTOFromEntity(feedbackAdded);
        }else{
            return null;
        }
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
