package w04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1874 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    int[] origin = new int[N];
    int[] stack = new int[N];
    int idx = 0;
    int originIdx = 0;

    for (int i = 0; i < N; i++) {
      origin[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 1; i <= N; i++) {
      sb.append("+").append("\n");
      stack[idx++] = i;
      while (idx != 0 && stack[idx-1] == origin[originIdx]) {
        idx--;
        originIdx++;
        sb.append("-").append("\n");
      }
    }
    System.out.println(originIdx);
    if (originIdx == N) {
      System.out.println(sb);
    } else {
      System.out.println("NO");
    }
  }
}
