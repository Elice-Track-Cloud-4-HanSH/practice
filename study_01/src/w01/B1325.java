package w01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1325 {
  static int[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Map<Integer, List<Integer>> map = new HashMap<>();

    String[] inputted = br.readLine().split(" ");
    int N = Integer.parseInt(inputted[0]);
    int M = Integer.parseInt(inputted[1]);
    visited = new int[N+1];
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < N+1; i++) {
      visited[i] = -1;
    }

    int a, b;

    for (int i = 0; i < M; i++) {
      inputted = br.readLine().split(" ");
      a = Integer.parseInt(inputted[0]);
      b = Integer.parseInt(inputted[1]);

      if (map.containsKey(a)) {
        map.get(a).add(b);
      } else {
        map.put(a, new ArrayList<>());
        map.get(a).add(b);
      }
    }

    Set<Integer> keys = new HashSet<>(map.keySet());
    for (int key: keys) {
      for (int trust: map.remove(key)) {
        visited[trust]++;
      }
      visited[key] = key;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < N+1; i++) {
      if (visited[i] == 0) sb.append(i).append(" ");
    }
    System.out.println(sb);
  }
}
