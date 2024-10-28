package w01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class B2293 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] inputted = br.readLine().split( " ");
    int N = Integer.parseInt(inputted[0]);
    int K = Integer.parseInt(inputted[1]);
    int[] coins = new int[N];
    int[] dp = new int[K+1];
    for (int i = 0; i < N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    // 0원을 만드는 방법은 단 하나이다!
    dp[0] = 1;

    for (int i = 0; i < N; i++) {
      // 동전은 오름차순 정렬이 되어있지 않을 수 있다.
      if (coins[i] > K) continue;
      for (int j = coins[i]; j <= K; j++) {
        dp[j] += dp[j-coins[i]];
      }
    }
    System.out.println(dp[K]);
  }
}
