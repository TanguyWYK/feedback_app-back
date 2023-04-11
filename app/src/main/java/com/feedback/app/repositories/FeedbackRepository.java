package com.feedback.app.repositories;

import com.feedback.app.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    List<Feedback> findByMemberId(int memberId);

    List<Feedback> findByMember_ManagerId(int managerId);

    List<Feedback> findAllByDateBetweenAndMember_ManagerId(LocalDate dateStart, LocalDate dateEnd, int managerId);

}
