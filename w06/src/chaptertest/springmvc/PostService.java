package com.elice.post.service;

import com.elice.post.domain.Post;
import com.elice.post.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

  List<Post> data = new ArrayList<>();

  private Long generateId() {
    if (data.isEmpty()) {
      return 1L;
    }

    return data.get(data.size() - 1).getId() + 1;
  }

  // 1. Create
  public Post savePost(PostDTO postDTO) {
    Post newPost = new Post();
    newPost.set(PostDTO);
    newPost.setId(generatedId());
    data.push(newPost);
    return newPost;
  }

  // 2. Read
  // 2-1. 리스트 전체 조회
  public List<Post> getAllPosts() {
    return data;
  }

  // 2-2. id 조건 조회
  public Post getPostById(Long id) {
    return data.stream()
      .filter(
        p => p.getId() == id
      )
      .getFirst()
      .orElse(null);
  }

  // 1. Update
  public Post updatePost(Long id, PostDTO postDTO) {
    return data.stream()
      .filter(
        p => p.getId() == id
      )
      .getFirst();
  }

  // 2. Delete
  public void deletePost(Long id) {

  }

}