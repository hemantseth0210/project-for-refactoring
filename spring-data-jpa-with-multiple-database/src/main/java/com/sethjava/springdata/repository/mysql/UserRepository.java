package com.sethjava.springdata.repository.mysql;

import com.sethjava.springdata.model.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
