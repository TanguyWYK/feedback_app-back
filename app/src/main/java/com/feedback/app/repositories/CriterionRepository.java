package com.feedback.app.repositories;

import com.feedback.app.models.Criterion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriterionRepository extends JpaRepository<Criterion, Integer> {

    List<Criterion> findByManagerId(int managerId);
}
