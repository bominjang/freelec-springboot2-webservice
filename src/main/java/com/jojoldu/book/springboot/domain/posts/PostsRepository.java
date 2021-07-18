package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//DB Layer 접근자. JpaRepository<Entity클래스, PK타입>을 상속하면 기본 CRUD 메소드 자동으로 생성.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
