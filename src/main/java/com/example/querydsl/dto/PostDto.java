package com.example.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.example.querydsl.dto
 * fileName       : PostDto
 * author         : hj
 * date           : 2023-05-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-25        hj       최초 생성
 */
@Data
@NoArgsConstructor
public class PostDto {

    private Long postId;

    private Long peopleId;

    private String postName;

    private String peopleName;

    @QueryProjection
    public PostDto(Long postId, Long peopleId, String postName, String peopleName){
        this.postId = postId;
        this.peopleId = peopleId;
        this.postName = postName;
        this.peopleName = peopleName;
    }
}
