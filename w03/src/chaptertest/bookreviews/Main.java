package chaptertest.bookreviews;

import java.util.Arrays;
import java.util.List;

import static chaptertest.bookreviews.BookAnalyzer.calculateAverageRating;
import static chaptertest.bookreviews.BookAnalyzer.findBooksWithRatingAbove;

/*
도서 리뷰 분석
도서관에서 제공하는 데이터를 바탕으로 책의 평점과 리뷰를 분석하는 프로그램을 개발해야 합니다.

아래 지시사항을 참고하여 코드를 작성해 보세요.

각 책은 제목, 저자, 그리고 여러 리뷰로 구성되어 있습니다. 각 리뷰에는 평점(1점부터 5점까지)과 리뷰어의 코멘트가 포함됩니다.
Book 클래스와 Review 클래스를 확인합니다.
BookAnalyzer 클래스 내에 다음 메서드를 구현합니다.
  double calculateAverageRating(List<Book> books): 주어진 모든 책의 평균 평점을 계산합니다.
  List<Book> findBooksWithRatingAbove(List<Book> books, int rating): 특정 평점 이상을 받은 책들의 목록을 반환합니다.
Main 클래스를 실행하여 메서드가 의도대로 동작하는 지 확인합니다.

출력 예시
🎯 전체 책 평점: 4.00

📌 4점 이상의 책 목록:
Harry Potter - J.K. Rowling
The Hobbit - J.R.R. Tolkien
 */

public class Main {
  public static void main(String[] args) {
    // 책 및 리뷰 데이터 초기화
    Book book1 = new Book("Harry Potter", "J.K. Rowling", Arrays.asList(new Review(5, "Amazing!"), new Review(4, "Great!")));
    Book book2 = new Book("The Hobbit", "J.R.R. Tolkien", Arrays.asList(new Review(5, "Excellent!"), new Review(3, "Good!")));
    Book book3 = new Book("1984", "George Orwell", Arrays.asList(new Review(3, "Thought-provoking"), new Review(4, "Interesting")));
    List<Book> books = Arrays.asList(book1, book2, book3);

    // 평균 평점 계산
    double averageRating = calculateAverageRating(books);
    System.out.printf("🎯 전체 책 평점: %.2f\n", averageRating);

    // 특정 평점 이상의 책 찾기
    int ratingThreshold = 4;
    List<Book> highRatedBooks = findBooksWithRatingAbove(books, ratingThreshold);
    System.out.println("\n📌 " + ratingThreshold + "점 이상의 책 목록:");
    highRatedBooks.forEach(book -> System.out.println(book.getTitle() + " - " + book.getAuthor()));
  }
}
