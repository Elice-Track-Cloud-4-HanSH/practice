package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2470 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] liquid = new int[N];
    String[] inputted = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      liquid[i] = Integer.parseInt(inputted[i]);
    }
    Arrays.sort(liquid);

    int min = Integer.MAX_VALUE;
    int[] idxs = new int[2];

    int left = 0;
    int right = N-1;

    while (left < right) {
      int t = Math.abs(liquid[left] + liquid[right]);
      if (min > t) {
        min = t;
        idxs[0] = liquid[left];
        idxs[1] = liquid[right];
      }
      int temp = liquid[left] + liquid[right] > 0 ? right-- : left++;
    }

    System.out.println(idxs[0] + " " + idxs[1]);
  }
}
