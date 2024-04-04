package com.example.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.example.querydsl.dto
 * fileName       : MemberDto
 * author         : hj
 * date           : 2023-05-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-24        hj       최초 생성
 */
@Data
@NoArgsConstructor
public class MemberDto {

    private Long teamId;

    private Long memberId;

    private String teamName;

    private String userName;

    private int age;

    @QueryProjection
    public MemberDto(Long teamId, Long memberId, String teamName, String userName, int age){
        this.teamId = teamId;
        this.memberId = memberId;
        this.teamName = teamName;
        this.userName = userName;
        this.age = age;
    }

}
