package com.github.shoothzj.reactor.h2.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("person")
@Setter
@Getter
public class PersonPo {
    @Id
    private Long id;

    @Column("name")
    private String name;

    @Column("age")
    private Integer age;

    @Column("create_time")
    @CreatedDate
    private LocalDateTime createTime;

    @Column("update_time")
    @LastModifiedDate
    private LocalDateTime updateTime;
}
