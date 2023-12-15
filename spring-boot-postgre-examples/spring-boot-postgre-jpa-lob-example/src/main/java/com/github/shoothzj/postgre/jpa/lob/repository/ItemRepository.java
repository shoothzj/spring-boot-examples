package com.github.shoothzj.postgre.jpa.lob.repository;

import com.github.shoothzj.postgre.jpa.lob.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAll();

    Optional<Item> findById(Long itemId);

    Item save(Item item);
}
