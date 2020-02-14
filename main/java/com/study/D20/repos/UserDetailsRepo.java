package com.study.D20.repos;

import com.study.D20.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserDetailsRepo extends CrudRepository<User, Long> {

    List<User> findByStatus(String status);
    List<User> findByDate(String date);


}