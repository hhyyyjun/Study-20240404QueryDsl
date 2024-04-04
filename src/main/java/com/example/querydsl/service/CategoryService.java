package com.example.querydsl.service;

import com.example.querydsl.dto.CategoryDto;
import com.example.querydsl.dto.QCategoryDto;
import com.example.querydsl.entity.Category;
import com.example.querydsl.repository.CategoryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.querydsl.entity.QCategory.category;

/**
 * packageName    : com.example.service
 * fileName       : MenuService
 * author         : hj
 * date           : 2023-05-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-23        hj       최초 생성
 */

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final JPAQueryFactory jpaQueryFactory;
    private final CategoryRepository categoryRepository;

    public List<CategoryDto> getCategoryList(){
        return jpaQueryFactory.select(new QCategoryDto(
                        category.id,
                        category.menuName,
                        category.likes,
                        category.items
                ))
                .from(category)
                .fetch();
    }

    public void insertCategory(String menuName, Long likes, String items){
        Category category = Category.builder()
                        .menuName(menuName)
                        .likes(likes)
                        .items(items)
                        .build();
        categoryRepository.save(category);
    }

    public void updateCategory(Long id, String menuName, Long likes, String items){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            Category category1 = category.get();
            category1.setMenuName(menuName);
            category1.setLikes(likes);
            category1.setItems(items);
            categoryRepository.save(category1);
        }
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public List<CategoryDto> getCategoryWhereList(Long id){
        return jpaQueryFactory.select(new QCategoryDto(
                        category.id,
                        category.menuName,
                        category.likes,
                        category.items
                ))
                .from(category)
//                .where(category.id.eq(id))
                .where(category.id.between(5,11))
                .fetch();
    }

    public List<CategoryDto> getCategoryOrderList(){
        return jpaQueryFactory.select(new QCategoryDto(
                        category.id,
                        category.menuName,
                        category.likes,
                        category.items
                ))
                .from(category)
                .orderBy(category.id.desc())
                .fetch();
    }
}
