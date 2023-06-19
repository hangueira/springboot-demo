package com.hks713.demo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@SequenceGenerator(
        name = "POST_SEQ_GENERATOR",
        sequenceName = "POST_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "POST_SEQ_GENERATOR")
    @Column(name = "POST_ID")
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Lob
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
