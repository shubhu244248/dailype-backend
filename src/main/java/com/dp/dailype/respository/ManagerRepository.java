package com.dp.dailype.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dp.dailype.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
