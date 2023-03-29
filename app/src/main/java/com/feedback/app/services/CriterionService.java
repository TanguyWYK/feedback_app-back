package com.feedback.app.services;

import com.feedback.app.dto_out.CriterionDTO;
import com.feedback.app.dto_out.FeedbackDTO;
import com.feedback.app.models.Criterion;
import com.feedback.app.models.Feedback;
import com.feedback.app.repositories.CriterionRepository;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Getter
@Setter
@Service
public class CriterionService {

    @Autowired
    private CriterionRepository criterionRepository;

    public Iterable<CriterionDTO> getAllCriteria(){
        Iterable<Criterion> criteria = criterionRepository.findAll();
        ArrayList<CriterionDTO> criterionDTOS = new ArrayList<>();
        for(Criterion criterion : criteria){
            ModelMapper modelMapper = new ModelMapper();
            CriterionDTO criterionDTO = modelMapper.map(criterion, CriterionDTO.class);
            criterionDTOS.add(criterionDTO);
        }
        return criterionDTOS;
    }
}
