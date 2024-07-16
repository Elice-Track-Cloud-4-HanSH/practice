package chaptertest.bookreviews;

import java.util.ArrayList;
import java.util.List;

public class Book {
  private String title;
  private String author;
  private List<Review> reviews = new ArrayList<>();

  public Book(String title, String author, List<Review> reviews) {
    this.title = title;
    this.author = author;
    this.reviews = reviews;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public List<Review> getReviews() {
    return reviews;
  }
}
