package com.feedback.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "feedbacks")
public class Feedback {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_criterion", referencedColumnName = "id")
    private Criterion criterion;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_member",referencedColumnName = "id")
    private Member member;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int value;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_manager_this_month",referencedColumnName = "id")
    private Manager managerThisMonth;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

}

