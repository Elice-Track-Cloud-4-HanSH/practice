package w01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 그리디 + DP
public class B1149 {
  static int RED = 0;
  static int GREEN = 1;
  static int BLUE = 2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[][] sums = new int[N][3];
    int[][] nums = new int[N][3];

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        nums[i][j] = Integer.parseInt(input[j]);
      }
    }

    sums[0][0] = nums[0][0];
    sums[0][1] = nums[0][1];
    sums[0][2] = nums[0][2];

    System.out.println(sums[0][RED] + " " + sums[0][GREEN] + " " + sums[0][BLUE]);
    // 현재 g -> 최소(이전 r, 이전 b) + num g
    for (int i = 1; i < N; i++) {
      sums[i][RED] = nums[i][RED] + Math.min(sums[i-1][GREEN], sums[i-1][BLUE]);
      sums[i][GREEN] = nums[i][GREEN] + Math.min(sums[i-1][RED], sums[i-1][BLUE]);
      sums[i][BLUE] = nums[i][BLUE] + Math.min(sums[i-1][RED], sums[i-1][GREEN]);

      System.out.println(sums[i][RED] + " " + sums[i][GREEN] + " " + sums[i][BLUE]);
    }

    int min = Math.min(sums[N-1][RED], sums[N-1][GREEN]);
    min = Math.min(min, sums[N-1][BLUE]);

    System.out.println(min);
  }
}
