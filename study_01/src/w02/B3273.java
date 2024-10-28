package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B3273 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    String[] temp = br.readLine().split(" ");
    int X = Integer.parseInt(br.readLine());
    int sum = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(temp[i]);
    }
    Arrays.sort(arr);
    for (int i = 0; i < N-1; i++) {
      for (int j = N-1; j > i; j--) {
        if (arr[i] + arr[j] == X) {
          sum++;
          break;
        }
        if (arr[i] + arr[j] < X) break;
      }
    }

    System.out.println(sum);
  }
}
