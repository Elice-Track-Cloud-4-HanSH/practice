package w04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2839 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[5001];
    Arrays.fill(dp, 5001);
    dp[3] = 1; dp[5] = 1;
    for (int i = 6; i <= N; i++) {
      dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
    }
    System.out.println(dp[N] > 5000 ? -1 : dp[N]);

    for (int i = 0; i <= N; i++) {
      System.out.println(i + " " + dp[i]);
    }
  }
}
