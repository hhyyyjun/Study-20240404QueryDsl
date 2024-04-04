package com.example.querydsl.repository;

import com.example.querydsl.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.example.repository
 * fileName       : MemberRepository
 * author         : hj
 * date           : 2023-05-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-23        hj       최초 생성
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
