package com.feedback.app.repositories;

import com.feedback.app.models.Criteria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaRepository extends CrudRepository<Criteria, Integer> {
}
