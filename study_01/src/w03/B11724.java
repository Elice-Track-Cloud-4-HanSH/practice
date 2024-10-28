package w03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11724 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException {
    String[] inputted = br.readLine().split(" ");
    int N = Integer.parseInt(inputted[0]);
    int M = Integer.parseInt(inputted[1]);

    System.out.println(solution(N, M));
  }

  static int solution(int N, int M) throws IOException {
    int[] graph = new int[N+1];
    for (int i = 0; i < N+1; i++) graph[i] = i;

    for (int i = 0; i < M; i++) {
      String[] inputted = br.readLine().split(" ");
      int a = Integer.parseInt(inputted[0]);
      int b = Integer.parseInt(inputted[1]);
      if (a > b) {
        graph[a] = graph[graph[b]];
      } else {
        graph[b] = graph[graph[a]];
      }
    }

    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      graph[i] = graph[graph[i]];
      if (graph[i] == i) cnt++;
    }
    return cnt;
  }
}
