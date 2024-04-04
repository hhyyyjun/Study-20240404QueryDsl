package com.example.querydsl.entity;

import lombok.*;

import javax.persistence.*;

/**
 * packageName    : com.example.entity
 * fileName       : Category
 * author         : hj
 * date           : 2023-05-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-23        hj       최초 생성
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @Column(name = "menuName")
    private String menuName;

    private Long likes;

    private String items;
}
