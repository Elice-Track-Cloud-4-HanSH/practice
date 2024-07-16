package w01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2294 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] inputted = br.readLine().split(" ");
    int n = Integer.parseInt(inputted[0]);
    int k = Integer.parseInt(inputted[1]);
    int[] coins = new int[n];
    int[] dp = new int[k+1];

    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int[] temp = new int[k+1];
    for (int i = 0; i < k+1; i++) {
      temp[i] = i;
    }
    printDetail(temp);

    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 0; i < n; i++) {
      for (int money = coins[i]; money < k + 1; money = money++) {
        if (dp[money] > dp[money-coins[i]]+1) dp[money] = dp[money-coins[i]]+1;
//        dp[money] = Math.min(1 + dp[money - coins[i]], dp[money]);
      }
      printDetail(dp);
    }

    System.out.println(dp[k]);
  }

  static void printDetail(int[] arr) {
    for (int count: arr) {
      System.out.printf("%10d ", count);
    }
    System.out.println();
  }
}
