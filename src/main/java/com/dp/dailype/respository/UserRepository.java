package com.dp.dailype.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dp.dailype.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
