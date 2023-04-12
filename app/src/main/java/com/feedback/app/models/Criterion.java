package com.feedback.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Entity
@Table(name = "criteria")
public class Criterion {

    public Criterion(int id, int managerId){
        this.setId(id);
        this.setManagerId(managerId);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_manager")
    private int managerId;

    private String name;

}
