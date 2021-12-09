package com.github.shoothzj.mysql.common.repository;

import com.github.shoothzj.mysql.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
