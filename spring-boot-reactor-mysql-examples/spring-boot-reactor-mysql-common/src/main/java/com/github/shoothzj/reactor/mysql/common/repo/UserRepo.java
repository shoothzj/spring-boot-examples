package com.github.shoothzj.reactor.mysql.common.repo;

import com.github.shoothzj.reactor.mysql.common.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepo extends ReactiveCrudRepository<User, String> {
}
