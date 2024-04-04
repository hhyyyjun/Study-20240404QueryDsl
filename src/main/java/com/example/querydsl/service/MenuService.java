package com.example.querydsl.service;

import com.example.querydsl.dto.MenuDto;
import com.example.querydsl.entity.Menu;
import com.example.querydsl.entity.QMenu;
import com.example.querydsl.repository.MenuRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : com.example.querydsl.service
 * fileName       : MenuService
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
public class MenuService {

    private final MenuRepository menuRepository;
    private final JPAQueryFactory jpaQueryFactory;

    public List<MenuDto> findAllWithQuerydsl() {
        QMenu parent = new QMenu("parent");
        QMenu child = new QMenu("child");

        List<Menu> result = jpaQueryFactory.selectFrom(parent)
                .distinct()
                .leftJoin(parent.children, child)
                .fetchJoin()
                .where(parent.parent.isNull())
                .orderBy(parent.listOrder.asc(), child.listOrder.asc())
                .fetch();

        return result.stream().map(MenuDto::new).collect(Collectors.toList());
//        return null;
    }
}
