package com.feedback.app.controllers;

import com.feedback.app.models.Manager;
import com.feedback.app.services.ManagerService;
import com.feedback.app.utilities.UsingJson;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
@Data
@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping(value = "/managers",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getAllManagers() throws InvocationTargetException, IllegalAccessException {
        Iterable<Manager> managers = managerService.getAllManagers();
        return new ResponseEntity<>(buildJsonArray(managers).toString(), HttpStatus.OK);
    }

    private ArrayList<UsingJson> buildJsonArray(Iterable<Manager> managers) throws InvocationTargetException, IllegalAccessException {
        var managersOut = new ArrayList<UsingJson>();
        for (Manager manager: managers) {
            var json = new UsingJson(manager);
            managersOut.add(json);
        }
        return managersOut;
    }

}
