package com.github.shoothzj.postgre.jpa.lob.controller;

import com.github.shoothzj.postgre.jpa.lob.domain.Item;
import com.github.shoothzj.postgre.jpa.lob.repository.ItemRepository;
import com.github.shoothzj.postgre.jpa.lob.util.StringTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TestController {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    @GetMapping("/find-all")
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Transactional
    @GetMapping("/save")
    public Item save() {
        Item item = new Item();
        item.setName(UUID.randomUUID().toString());
        item.setComment(StringTool.randomStr(65535));
        return itemRepository.save(item);
    }

    @Transactional
    @GetMapping("/save-find-all")
    public List<Item> saveFindAll() {
        Item item = new Item();
        item.setName(UUID.randomUUID().toString());
        item.setComment(StringTool.randomStr(65535));
        itemRepository.save(item);
        return itemRepository.findAll();
    }
}
