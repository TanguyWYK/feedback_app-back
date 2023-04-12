package com.feedback.app.controllers;

import com.feedback.app.dto_out.ManagerDTO;
import com.feedback.app.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.InvocationTargetException;
@Controller
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping(value = "/managers",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<ManagerDTO>> getAllManagers() throws InvocationTargetException, IllegalAccessException {
        Iterable<ManagerDTO> managerDTOs = managerService.getAllManagers();
        return new ResponseEntity<>(managerDTOs, HttpStatus.OK);
    }

}
