package com.github.shoothzj.reactor.h2.repo;

import com.github.shoothzj.reactor.h2.domain.PersonPo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepo extends ReactiveCrudRepository<PersonPo, Long> {
}
