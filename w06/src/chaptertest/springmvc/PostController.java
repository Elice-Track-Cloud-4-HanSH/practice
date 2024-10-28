package com.elice.post.controller;

import com.elice.post.domain.Post;
import com.elice.post.dto.PostDTO;
import com.elice.post.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  // Post의 CRUD API를 만들어봅니다.

  // 1. Create
  @PostMapping("/posts")
  public Post createPost(@RequestBody PostDTO postDTO) {
    return null;
  }

  // 2. Read
  // 2-1. 리스트 전체 조회
  @GetMapping("/posts")
  public List<Post> getAllPosts() {
    return null;
  }

  // 2-2. id 조건 조회
  @GetMapping("/posts/{id}")
  public Post getPostById(@PathVariable Long id) {
    return null;
  }

  // 1. Update
  @PutMapping("/posts/{id}")
  public Post updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
    return postService.updatePost(id, postDTO);
  }

  // 2. Delete
  @DeleteMapping("/posts/{id}")
  public void deletePost(@PathVariable Long id) {
    postService.deletePost(id);
  }
}