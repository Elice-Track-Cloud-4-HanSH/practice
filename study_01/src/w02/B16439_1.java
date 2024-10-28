package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16439_1 {
  public static int maxFlavor = 0;
  public static int[][] flavorArr;
  static boolean[] check;
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] firstLine = br.readLine().split(" ");
    N = Integer.parseInt(firstLine[0]);
    M = Integer.parseInt(firstLine[1]);

    flavorArr = new int[N+1][M+1];
    check = new boolean[M+1];

    for (int i = 1; i <= N; i++) {
      String[] inputted = br.readLine().split(" ");
      for (int j = 1; j <= M; j++) {
        flavorArr[i][j] = Integer.parseInt(inputted[j-1]);
      }
    }
    br.close();

    char[] permute = new char[4];
    for (char i = 0; i < 4; i++) {
      permute[i] = i;
    }

    solution(permute, 1);
    System.out.println(maxFlavor);
  }

  public static void solution(char[] permute, int curIdx) {
    if (curIdx > 3) {
      int flavor = 0;
      for (int i = 1; i <= N; i++) {
        int localFlavorMax = 0;
        for (int chickenIdx = 1; chickenIdx <= 3; chickenIdx++) {
          localFlavorMax = Math.max(localFlavorMax, flavorArr[i][permute[chickenIdx]]);
        }
        flavor += localFlavorMax;
      }
      maxFlavor = Math.max(maxFlavor, flavor);
      return;
    }
    for (char i = 1; i <= M; i++) {
      if (check[i]) continue;
      permute[curIdx] = i;
      check[i] = true;
      solution(permute, curIdx+1);
      check[i] = false;
    }
  }
}
