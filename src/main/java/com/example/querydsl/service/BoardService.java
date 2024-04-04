package com.example.querydsl.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.example.querydsl.service
 * fileName       : BoardService
 * author         : hj
 * date           : 2023-05-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-25        hj       최초 생성
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final JPAQueryFactory jpaQueryFactory;

}
