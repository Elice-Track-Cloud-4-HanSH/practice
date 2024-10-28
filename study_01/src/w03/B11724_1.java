package w03;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class B11724_1 {

  static boolean[] visited;
  static int N, M;
  // 가중치가 주어진다면 boolean 대신 int 사용!
  static boolean[][] Link;
  static Queue<Integer> queue;
  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\HanSH\\Downloads\\11724\\11724-2.in")));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputted = br.readLine().split(" ");
    N = Integer.parseInt(inputted[0]);
    M = Integer.parseInt(inputted[1]);

    // n번 방문, 몇번과 몇번이 가중치로 연결이 없기에
    // boolean으로 배열 생성 ← 단순히 연결되어있는지, 방문했는지만 확인하면 된다.
    visited = new boolean[1001];
    Link = new boolean[1001][1001];

    // BFS를 위한 큐 생성
    queue = new LinkedList<>();

    for (int i = 0; i < M; i++) {
      // StringTokenizer를 사용하는 것이 좋지만
      // 문자열이 꽤 짧은 경우에는 split 함수를 사용해도 무방하다.
      inputted = br.readLine().split(" ");
      int a = Integer.parseInt(inputted[0]);
      int b = Integer.parseInt(inputted[1]);
      // 서로가 연결되어있음을 확인
      Link[a][b] = Link[b][a] = true;
    }

    System.out.println(solutionDfs(N));

    visited = new boolean[1001];
    System.out.println(solutionBfs(N));
  }

  static void dfs(int v) {
      visited[v] = true;
      for (int i = 1; i <= N; i++) {
        // 이미 방문한 정점이면 다시 확인할 필요 없음 → 이미 하나의 그래프로 연결됐음을 확인
        // 연결되지 않은 정점이라면 방문할 필요가 없음
        if (visited[i] || !Link[v][i]) continue;
        dfs(i);
      }
  }

  static int solutionDfs(int N) {
    int count = 0;
    // 각 정점을 시작점으로 하는 루프 실행
    for (int i = 1; i <= N; i++) {
      if (visited[i]) continue;
      dfs(i);
      count++;
    }
    return count;
  }

  static void bfs(int v) {
    // 정점을 큐에 삽입
    queue.add(v);
    // 큐가 빌 때까지 실행
    while (!queue.isEmpty()) {
      // queue.poll : 맨 첫 값을 삭제 후 그 값 반환
      int u = queue.poll();
      if (visited[u]) continue;
      visited[u] = true;
      // 해당 정점에 대해 너비 탐색 진행
      for (int i = 1; i <= N; i++) {
        if (!Link[u][i]) continue;
        if (!visited[i]) queue.add(i);
      }
    }
  }

  static int solutionBfs(int N) {
    int count = 0;
    // 각 정점을 시작점으로 하는 루프 실행
    for (int i = 1; i <= N; i++) {
      if (visited[i]) continue;
      bfs(i);
      count++;
    }
    return count;
  }
}
