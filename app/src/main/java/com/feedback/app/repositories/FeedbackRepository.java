package com.feedback.app.repositories;

import com.feedback.app.models.Feedback;
import com.feedback.app.models.FeedbackId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, FeedbackId> {

    List<Feedback> findByMemberId(int memberId);

}
