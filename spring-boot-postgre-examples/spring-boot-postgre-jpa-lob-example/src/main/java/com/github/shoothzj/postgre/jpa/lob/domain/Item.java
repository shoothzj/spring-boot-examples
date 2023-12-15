package com.github.shoothzj.postgre.jpa.lob.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_REG_ID_SEQ")
    @SequenceGenerator(name = "T_REG_ID_SEQ", sequenceName = "T_REG_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(length = 256)
    private String name;

    @Lob
    @Column(name = "comment")
    private String comment;

    public Item() {
    }

    public Item(Long id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
