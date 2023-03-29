package com.feedback.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "feedbacks")
public class Feedback {
    @EmbeddedId
    @PrimaryKeyJoinColumn
    @Column(insertable=false, updatable=false)
    private FeedbackId feedbackId;

    @Column(name= "id_criteria", insertable=false, updatable=false)
    private int criteriaId;

    @Column(name= "id_member",insertable=false, updatable=false)
    private int memberId;

    private int value;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

}

