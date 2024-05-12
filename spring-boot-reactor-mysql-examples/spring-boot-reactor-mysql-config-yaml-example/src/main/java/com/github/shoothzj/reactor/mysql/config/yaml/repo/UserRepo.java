package com.github.shoothzj.reactor.mysql.config.yaml.repo;

import com.github.shoothzj.reactor.mysql.config.yaml.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepo extends ReactiveCrudRepository<User, String> {
}
