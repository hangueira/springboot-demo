package com.hks713.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@SequenceGenerator(
        name = "HELLO_SEQ_GENERATOR",
        sequenceName = "HELLO_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "HELLO_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @Lob
    private String description;
}