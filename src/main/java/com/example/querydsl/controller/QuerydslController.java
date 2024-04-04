package com.example.querydsl.controller;

import com.example.querydsl.dto.CategoryDto;
import com.example.querydsl.dto.MemberDto;
import com.example.querydsl.dto.MenuDto;
import com.example.querydsl.dto.PostDto;
import com.example.querydsl.service.CategoryService;
import com.example.querydsl.service.MenuService;
import com.example.querydsl.service.PostService;
import com.example.querydsl.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * packageName    : com.example.controller
 * fileName       : QuerydslController
 * author         : hj
 * date           : 2023-05-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-23        hj       최초 생성
 */
@Controller
@AllArgsConstructor
public class QuerydslController {

    private final CategoryService categoryService;
    private final UserService userService;
    private final MenuService menuService;
    private final PostService postService;

    @GetMapping("/select")
    public ResponseEntity<List<CategoryDto>> select(){
        List<CategoryDto> cateList = categoryService.getCategoryList();

        return ResponseEntity.ok(cateList);
    }

    @PostMapping("/insertData")
    @ResponseBody
    public void  insertData(@RequestBody categoryDto request){
        categoryService.insertCategory(request.getMenuName(), request.getLikes(), request.getItems());
    }

    @PostMapping("/updateData")
    @ResponseBody
    public void updateData(@RequestBody categoryDto request){
        categoryService.updateCategory(request.getId(), request.getMenuName(), request.getLikes(), request.getItems());
    }

    @PostMapping("deleteData")
    @ResponseBody
    public void deleteData(@RequestBody categoryDto request){
        categoryService.deleteCategory(request.getId());
    }

    @PostMapping("whereEx")
    @ResponseBody
    public ResponseEntity<List<CategoryDto>> whereEx(@RequestBody categoryDto request){
        List<CategoryDto> cateList = categoryService.getCategoryWhereList(request.getId());

        return ResponseEntity.ok(cateList);
    }

    @GetMapping("orderEx")
    public ResponseEntity<List<CategoryDto>> orderEx(){
        List<CategoryDto> cateList = categoryService.getCategoryOrderList();

        return ResponseEntity.ok(cateList);
    }


    @GetMapping("joinEx")
    public ResponseEntity<List<MemberDto>> getJoinList(){
        List<MemberDto> joinList = userService.getJoinList();
        return ResponseEntity.ok(joinList);
    }


    @GetMapping("menuJoinList")
    public ResponseEntity<List<MenuDto>> menuJoinList() {
        List<MenuDto> menuJoinList = menuService.findAllWithQuerydsl();
        return ResponseEntity.ok(menuJoinList);
    }

    @GetMapping("boardList")
    public ResponseEntity<List<PostDto>> getBoardList() {
        List<MenuDto> menuJoinList = menuService.findAllWithQuerydsl();
        List<PostDto> postList = postService.getPostList();
        return ResponseEntity.ok(postList);
    }

    @Data
    static class categoryDto{
        Long id;
        String menuName;
        Long likes;
        String items;
    }

}
