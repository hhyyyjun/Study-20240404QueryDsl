package com.example.querydsl.service;

import com.example.querydsl.dto.MemberDto;
import com.example.querydsl.dto.QMemberDto;
import com.example.querydsl.entity.QMember;
import com.example.querydsl.entity.QTeam;
import com.example.querydsl.repository.MemberRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.querydsl.entity.QMember.member;
import static com.example.querydsl.entity.QTeam.team;

/**
 * packageName    : com.example.querydsl.service
 * fileName       : UserService
 * author         : hj
 * date           : 2023-05-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-24        hj       최초 생성
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final JPAQueryFactory jpaQueryFactory;
    private final MemberRepository memberRepository;

    public List<MemberDto> getJoinList(){
        return jpaQueryFactory.select(new QMemberDto(
                team.id,
                member.id,
                team.teamName,
                member.userName,
                member.age
                ))
                .from(team)
                .leftJoin(member).on(team.id.eq(member.team.id))
                .where(team.id.eq(1L))
                .fetch();
    }
}
