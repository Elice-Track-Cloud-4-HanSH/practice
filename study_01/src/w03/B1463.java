package w03;

import java.io.*;

public class B1463 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());

    System.out.println(solution(X));
  }

  static int solution(int X) {
    // 최소를 구하기 위한 DP 구조 생성
    int[] dp = new int[X+1];
    int canDevidedBy2, canDevidedBy3, min;

    // 입력받은 수가 1인 경우는 0번의 연산으로 1을 만들 수 있다.
    if (X == 1) return 0;
    // 입력받은 수가 2, 3인 경우, 각각 2와 3으로 나누는 방법으로 1을 만들 수 있다.
    if (X == 2 || X == 3) return 1;

    // 2, 3은 한번만에 도출이 가능하니 1로 초기화한다.
    dp[2] = dp[3] = 1;
    for (int i = 4; i <= X; i++) {
      // 2로 나눠지는 경우와 아닌 경우, 3으로 나눠지는 경우와 아닌 경우를 설정
      // 나눠진다면 이전에 구한 최소 연산값을 이용
      // 나눠지지 않는다면 최대값으로 설정
      canDevidedBy2 = i % 2 == 0 ? dp[i / 2] : Integer.MAX_VALUE;
      canDevidedBy3 = i % 3 == 0 ? dp[i / 3] : Integer.MAX_VALUE;
      min = Math.min(canDevidedBy3, canDevidedBy2);
      // 결국 i를 1로 만드는 최소 연산 횟수는
      // 1) i를 3으로 나눈 값의 최소 연산 횟수
      // 2) i를 2로 나눈 값의 최소 연산 횟수
      // 3) i에서 1 뺀 값의 최소 연산 횟수
      // 1), 2), 3)의 최소에 1(해당 값까지의 연산)을 더한 것이다.
      dp[i] = Math.min(min, dp[i-1]) + 1;
    }
    return dp[X];
  }
}
