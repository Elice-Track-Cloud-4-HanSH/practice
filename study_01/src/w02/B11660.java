package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11660 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputted = br.readLine().split(" ");

    int N = Integer.parseInt(inputted[0]);
    int M = Integer.parseInt(inputted[1]);
    int[][] matrix = new int[N+1][N+1];
    for (int i = 0; i < N; i++) {
      inputted = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        matrix[i+1][j+1] = matrix[i+1][j] + Integer.parseInt(inputted[j]);
      }
    }

    for (int loops = 0; loops < M; loops++) {
      inputted = br.readLine().split(" ");
      int x1 = Integer.parseInt(inputted[0]);
      int y1 = Integer.parseInt(inputted[1]);
      int x2 = Integer.parseInt(inputted[2]);
      int y2 = Integer.parseInt(inputted[3]);

      int localSum = 0;
      for (int r = x1; r <= x2; r++) {
        localSum += matrix[r][y2] - matrix[r][y1-1];
      }
      System.out.println(localSum);
    }
  }
}
