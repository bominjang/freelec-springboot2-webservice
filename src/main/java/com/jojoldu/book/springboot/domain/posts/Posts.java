package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //lombok의 annotation
@NoArgsConstructor//lombok의 annotation. 기본생성자를 자동추가.
@Entity//JPA의 annotation
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //생성자 대신 빌더 클래스 사용. 빌더를 사용하면 어떤 필드에 어떤 값을 채워야할 지 명확하게 인지할 수 있음.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
