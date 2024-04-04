package com.example.querydsl.dto;

import com.example.querydsl.entity.Menu;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : com.example.querydsl.dto
 * fileName       : MenuDto
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
public class MenuDto {

    private Long id;
    private String name;
    private int listOrder;
    private List<MenuDto> children;

    public MenuDto(final Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.listOrder = menu.getListOrder();
        this.children = menu.getChildren().stream().map(MenuDto::new).collect(Collectors.toList());
    }
}
