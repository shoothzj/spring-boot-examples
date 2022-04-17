package com.github.shoothzj.mysql.common.repository;

import com.github.shoothzj.mysql.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Query(value = "select username from t_user u where password = ?1 group by username", nativeQuery = true)
    List<String> findUserNameListByPasswordGroupByUsername(String password);

    @Transactional
    @Query(value = "select * from t_user u where password = ?1 group by username", nativeQuery = true)
    List<User> findUserListByPasswordGroupByUsername(String password);

}
