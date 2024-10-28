package w01;

import java.io.*;
import java.util.*;

public class B18870 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Integer, Integer> map = new HashMap<>();
    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];
    int[] sorted = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      nums[i] = sorted[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(sorted);
    int rank = 0;

    for (int key: sorted) {
      if (!map.containsKey(key)) {
        map.put(key, rank++);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int num: nums) sb.append(map.get(num)).append(" ");
    System.out.println(sb);
  }
}
