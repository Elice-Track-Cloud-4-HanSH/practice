package w01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1149_1 {
  static int RED = 0;
  static int GREEN = 1;
  static int BLUE = 2;

  static int[][] costs;
  static int min = Integer.MAX_VALUE;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    costs = new int[N][3];
    for (int i = 0; i < N; i++) {
      String[] buffer = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        costs[i][j] = Integer.parseInt(buffer[j]);
      }
    }

    for (int i = 0; i < 3; i++) {
      solve(1, i, costs[0][i]);
    }
    System.out.println(min);
  }

  static void solve(int idx, int rgb, int val) {
    if (min < val) return;
    if (idx >= N) {
      min = val;
      return;
    }
    if (rgb == RED) {
      solve(idx+1, GREEN, val + costs[idx][1]);
      solve(idx+1, BLUE, val + costs[idx][2]);
    } else if (rgb == GREEN) {
      solve(idx+1, RED, val + costs[idx][0]);
      solve(idx+1, BLUE, val + costs[idx][2]);
    } else {
      solve(idx+1, RED, val + costs[idx][0]);
      solve(idx+1, GREEN, val + costs[idx][1]);
    }
  }
}
