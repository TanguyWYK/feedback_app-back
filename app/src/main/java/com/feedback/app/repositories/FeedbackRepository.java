package com.feedback.app.repositories;

import com.feedback.app.models.Feedback;
import com.feedback.app.models.FeedbackId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, FeedbackId> {

    List<Feedback> findByMemberId(int memberId);

}
