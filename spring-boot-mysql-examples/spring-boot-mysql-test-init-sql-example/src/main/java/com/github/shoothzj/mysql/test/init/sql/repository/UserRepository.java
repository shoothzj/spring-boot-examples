package com.github.shoothzj.mysql.test.init.sql.repository;

import com.github.shoothzj.mysql.test.init.sql.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}