package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11660_1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputted = br.readLine().split(" ");

    int N = Integer.parseInt(inputted[0]);
    int M = Integer.parseInt(inputted[1]);
    int[][] matrix = new int[N+1][N+1];

    // ================ 하나로 줄여보자! ================
//    for (int i = 0; i < N; i++) {
//      inputted = br.readLine().split(" ");
//      for (int j = 0; j < N; j++) {
//        matrix[i+1][j+1] = matrix[i+1][j] + Integer.parseInt(inputted[j]);
//      }
//    }
//
////    printMatrix(matrix);
//
//    for (int i = 1; i < N+1; i++) {
//      for (int j = 1; j < N+1; j++) {
//        matrix[i][j] += matrix[i-1][j];
//      }
//    }
    // ===============================================

    for (int i = 1; i <= N; i++) {
      inputted = br.readLine().split(" ");
      for (int j = 1; j <= N; j++) {
        matrix[i][j] = matrix[i-1][j]
                        + matrix[i][j-1]
                        - matrix[i-1][j-1]
                        + Integer.parseInt(inputted[j-1]);
      }
    }


    printMatrix(matrix);



    for (int loops = 0; loops < M; loops++) {
      inputted = br.readLine().split(" ");
      int x1 = Integer.parseInt(inputted[0]);
      int y1 = Integer.parseInt(inputted[1]);
      int x2 = Integer.parseInt(inputted[2]);
      int y2 = Integer.parseInt(inputted[3]);

      if (x1==x2 && y1==y2) {
        System.out.println();
      }

      System.out.println(
                matrix[x2][y2]
                - matrix[x1-1][y2]
                - matrix[x2][y1-1]
                + matrix[x1-1][y1-1]
      );
    }
  }

  static void printMatrix(int[][] matrix) {
    System.out.println();
    for (int[] rows : matrix) {
      for (int col : rows) {
        System.out.printf("%d ", col);
      }
      System.out.println();
    }
    System.out.println();
    System.out.println();
  }
}
