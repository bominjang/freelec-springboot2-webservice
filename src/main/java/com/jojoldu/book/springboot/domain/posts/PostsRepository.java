package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//DB Layer 접근자. JpaRepository<Entity클래스, PK타입>을 상속하면 기본 CRUD 메소드 자동으로 생성.
public interface PostsRepository extends JpaRepository<Posts, Long> {
    //SpringDataJpa에서 제공하지 않는 메소드는 이렇게 쿼리로 작성해도 됨.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
