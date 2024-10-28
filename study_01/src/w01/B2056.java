package w01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class B2056 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    boolean[][] works = new boolean [N+1][N+1];
    int[] check = new int[N+1];
    int[] dp = new int[N+1];
    int[] times = new int[N+1];

    Deque<Integer> deque = new LinkedList<>();
    for (int i = 1; i < N+1; i++) {
      String[] input = br.readLine().split(" ");
      int time = Integer.parseInt(input[0]);
      int inputWorks = Integer.parseInt(input[1]);

      if (inputWorks == 0) {
        deque.add(i);
        dp[i] = time;
      }
      times[i] = time;

      for (int j = 0; j < inputWorks; j++) {
        works[Integer.parseInt(input[j+2])][i] = true;
        check[i]++;
      }
    }

    while (!deque.isEmpty()) {
      int t = deque.removeFirst();
      for (int i = 1; i <= N; i++) {
        if (works[t][i] && t != i) {
          dp[i] = Math.max(dp[i], dp[t] + times[i]);
          check[i]--;
          if (check[i] == 0) {
            deque.add(i);
          }
        }
      }
    }

    int temp = 0;
    for (int i = 1; i < N+1; i++) {
      temp = Math.max(temp, dp[i]);
    }
    System.out.println(temp);
  }

  static void printDp(int[] dp) {
    for (int i = 1; i < dp.length; i++) {
      System.out.printf("%d ", dp[i]);
    }
    System.out.println();
    System.out.println();
  }
}
