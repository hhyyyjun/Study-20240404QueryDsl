package com.example.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.example.dto
 * fileName       : MemberDto
 * author         : hj
 * date           : 2023-05-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-23        hj       최초 생성
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryDto {

    private Long id;
    private String menuName;
    private Long likes;
    private String items;

    @QueryProjection
    public CategoryDto(Long id, String menuName, Long likes, String items){
        this.id = id;
        this.menuName = menuName;
        this.likes = likes;
        this.items = items;
    }
}
