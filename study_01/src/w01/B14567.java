package w01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class B14567 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputted = br.readLine().split(" ");

    int N = Integer.parseInt(inputted[0]);
    int M = Integer.parseInt(inputted[1]);
    StringBuilder sb = new StringBuilder();
    if (M == 0) {
      for (int i = 0; i < N; i++) {
        sb.append(1).append(" ");
      }
      System.out.println(sb);
      return;
    }

    boolean[][] curiculum = new boolean[N+1][N+1];
    int[] check = new int[N+1];
    int[] dp = new int[N+1];
    Arrays.fill(dp, 0);
    for (int i = 0; i < M; i++) {
      inputted = br.readLine().split(" ");
      curiculum[Integer.parseInt(inputted[0])][Integer.parseInt(inputted[1])] = true;
      check[Integer.parseInt(inputted[1])] += 1;
    }

    Deque<Integer> deque = new LinkedList<>();
    for (int i = 1; i < N+1; i++) {
      if (check[i] == 0) {
        deque.add(i);
        dp[i] = 1;
      }
    }

    while (!deque.isEmpty()) {
      int r = deque.removeFirst();
      for (int c = 1; c < N+1; c++) {
        if (curiculum[r][c]) {
          dp[c] = Math.max(dp[c], dp[r] + 1);
          check[c] -= 1;
          if (check[c] == 0) {
            deque.add(c);
          }
        }
      }
    }

    sb.setLength(0);
    for (int i = 1; i < N+1; i++) {
      sb.append(dp[i]).append(" ");
    }
    System.out.println(sb);
  }
}
