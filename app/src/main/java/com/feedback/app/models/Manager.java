package com.feedback.app.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

}
