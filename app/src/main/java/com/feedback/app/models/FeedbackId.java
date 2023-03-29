package com.feedback.app.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class FeedbackId implements Serializable {
    private int criteriaId;
    private int memberId;

    public FeedbackId(){
        criteriaId = 0;
        memberId = 0;
    }
    public FeedbackId(int criteriaId, int memberId) {
        criteriaId = criteriaId;
        memberId = memberId;
    }
}