package com.feedback.app.controllers;

import com.feedback.app.dto_out.CriterionDTO;
import com.feedback.app.services.CriterionService;
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
public class CriterionController {

    @Autowired
    private CriterionService criterionService;

    @GetMapping(value = "/criteria",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<CriterionDTO>> getAllCriteria() {
        Iterable<CriterionDTO> criterionDTOS = criterionService.getAllCriteria();
        return new ResponseEntity<>(criterionDTOS, HttpStatus.OK);
    }
    @GetMapping(value = "/criteria/{managerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<CriterionDTO>> getCriteriaByManagerId(@PathVariable String managerId) {
        Iterable<CriterionDTO> criterionDTOS = criterionService.getCriteriaByManagerId(Integer.parseInt(managerId));
        return new ResponseEntity<>(criterionDTOS, HttpStatus.OK);
    }
}
