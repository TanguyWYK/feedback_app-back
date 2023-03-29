package com.feedback.app.repositories;

import com.feedback.app.models.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Integer> {

    List<Manager> findByEmail(String email);

}
