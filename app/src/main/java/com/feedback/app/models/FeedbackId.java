package com.feedback.app.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class FeedbackId implements Serializable {
    private int id_criterion2;
    private int id_member2;

    public FeedbackId(){
        id_criterion2 = 0;
        id_member2 = 0;
    }
    public FeedbackId(int criterionId, int memberId) {
        id_criterion2 = criterionId;
        id_member2 = memberId;
    }
}