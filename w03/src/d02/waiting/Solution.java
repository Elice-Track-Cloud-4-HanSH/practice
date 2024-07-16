package d02.waiting;

import java.util.Arrays;

public class Solution {

  public static int solution(int[] input, int target) {
    // 이곳에 코드를 작성해 주세요.
    Arrays.sort(input);
    return Arrays.binarySearch(input, target);
  }

  private Solution() {}
}
