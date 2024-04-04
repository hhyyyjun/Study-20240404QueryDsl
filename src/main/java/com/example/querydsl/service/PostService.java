package com.example.querydsl.service;

import com.example.querydsl.dto.PostDto;
import com.example.querydsl.dto.QPostDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.querydsl.entity.QPeople.people;
import static com.example.querydsl.entity.QPost.post;

/**
 * packageName    : com.example.querydsl.service
 * fileName       : PostService
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
public class PostService {

    private final JPAQueryFactory jpaQueryFactory;

    public List<PostDto> getPostList(){
        return jpaQueryFactory.select(new QPostDto(
                post.id,
                people.id,
                post.postName,
                people.peopleName
                ))
                .from(post)
                .join(people).on(post.id.eq(people.id))
                .fetch();
    }

}
