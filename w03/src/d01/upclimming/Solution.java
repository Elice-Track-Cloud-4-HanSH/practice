package d01.upclimming;

import java.util.ListIterator;

class Solution {

  public static void solution(ListIterator<Integer> iterator) {
    int cur = 0;
    int step = 0;
    int result = 0;
    while (iterator.hasNext()) {
      step = iterator.next();
      if (cur < step) {
        result += 1;
      }
      cur = step;
    }
    // 이곳에 정답 코드를 작성해 주세요.
    System.out.println(result);
  }

  private Solution() {}
}

