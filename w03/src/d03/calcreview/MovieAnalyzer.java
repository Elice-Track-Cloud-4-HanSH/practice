package d03.calcreview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieAnalyzer {

  public static double calculateAverageRating(List<Movie> movies) {
    // 주어진 모든 영화의 평균 평점을 계산합니다.
    // 지시 사항을 참고하여 코드를 작성해 보세요.
//    double averageRating = 0.0;
//    for (Movie movie : movies) {
//      averageRating += movie.getReviews().stream()
//                .mapToInt(Review::getRating)
//                .average().else(0.0);
//    }
//    averageRating /= movies.size();
//    return averageRating;

//    return movies.stream()
//              .mapToDouble(
//                movie -> movie.getReviews().stream()
//                          .mapToInt(Review::getRating)
//                          .average()
//                          .orElse(0.0)
//              )
//              .average().orElse(0.0);

    return movies.stream()
              .flatMap(movie -> movie.getReviews().stream())
              .mapToInt(Review::getRating)
              .average()
              .orElse(0.0);
  }

  // 특정 평점 이상을 받은 영화들의 목록을 반환합니다.
  public static List<Movie> findMoviesWithRatingAbove(List<Movie> movies, int rating) {
    // 지시 사항을 참고하여 코드를 작성해 보세요.
//    List<Movie> result = new ArrayList<>();
//    for (Movie movie : movies) {
//      int reduce = movie.getReviews().stream()
//                .mapToInt(Review::getRating)
//                .sum();
//      if ((double)reduce / movie.getReviews().size() > rating) {
//        result.add(movie);
//      }
//    }
//    return result;

    return movies.stream().filter(
              (movie) -> {
                List<Review> reviews = movie.getReviews();
                int reduce = reviews.stream()
                          .mapToInt(Review::getRating)
                          .sum();
                return (double)reduce / reviews.size() > rating;
              }
    ).collect(Collectors.toList());
  }
}
