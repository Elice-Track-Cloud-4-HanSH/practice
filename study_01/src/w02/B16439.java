package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B16439 {
  public static int maxFlavor = 0;
  public static Map<Character, Integer> selectedChicken = new HashMap<>();
  public static char[][] flavorArr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] firstLine = br.readLine().split(" ");
    int N = Integer.parseInt(firstLine[0]);
    int M = Integer.parseInt(firstLine[1]);

    flavorArr = new char[N+1][M+1];

    for (int i = 1; i <= N; i++) {
      String[] inputted = br.readLine().split(" ");
      for (int j = 1; j <= M; j++) {
        flavorArr[i][j] = (char)Integer.parseInt(inputted[j-1]);
      }
    }
    br.close();

    solution(1, N, M, 0);
    System.out.println(maxFlavor);
  }

  static void solution(int N, int maxN, int M, int flavor) {
    if (N > maxN) {
      maxFlavor = Math.max(maxFlavor, flavor);
      return;
    }
    if (selectedChicken.keySet().size() < 3) {
      for (char chicken = 1; chicken <= M; chicken++) {
        backtracking(N, maxN, M, flavor, chicken);
      }
    } else {
      for (char chicken : selectedChicken.keySet()) {
        backtracking(N, maxN, M, flavor, chicken);
      }
    }
  }
  // 백트래킹을 이용한 방법
  // timeout이 떴다
  private static void backtracking(int N, int maxN, int M, int flavor, char chicken) {
    selectedChicken.put(chicken, selectedChicken.getOrDefault(chicken, 0) + 1);
    solution(N+1, maxN, M, flavor+flavorArr[N][chicken]);
    selectedChicken.put(chicken, selectedChicken.get(chicken) - 1);
    if (selectedChicken.get(chicken) == 0) selectedChicken.remove(chicken);
  }
}
