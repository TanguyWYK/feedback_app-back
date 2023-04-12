package com.feedback.app.services;

import com.feedback.app.dto_out.ManagerDTO;
import com.feedback.app.models.Manager;
import com.feedback.app.repositories.ManagerRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Data
@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public Iterable<ManagerDTO> getAllManagers(){
        Iterable<Manager>  managers = managerRepository.findAll();
        return buildDTOsFromEntity(managers);
    }

    private Iterable<ManagerDTO> buildDTOsFromEntity(Iterable<Manager> managers) {
        ArrayList<ManagerDTO> managerDTOS = new ArrayList<>();
        for (Manager manager : managers) {
            ModelMapper modelMapper = new ModelMapper();
            ManagerDTO managerDTO = modelMapper.map(manager, ManagerDTO.class);
            managerDTOS.add(managerDTO);
        }
        return managerDTOS;
    }

}
