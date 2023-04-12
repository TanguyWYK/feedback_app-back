package com.feedback.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "members")
public class Member {
    public Member(int id, int managerId){
        this.id = id;
        this.managerId = managerId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_manager")
    private int managerId;
    private String email;
}
