package com.feedback.app.services;

import com.feedback.app.models.Manager;
import com.feedback.app.repositories.ManagerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public Iterable<Manager> getAllManagers(){
        return managerRepository.findAll();
    }

}
