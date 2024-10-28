package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2559 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputted = br.readLine().split(" ");

    int N = Integer.parseInt(inputted[0]);
    int K = Integer.parseInt(inputted[1]);

    inputted = br.readLine().split(" ");
    int[] celcius = new int[N];
    for (int i = 0; i < N; i++) {
      celcius[i] = Integer.parseInt(inputted[i]);
    }

    int max = 0;
    int localSum = 0;

    for (int i = 0; i < K; i++) {
      max += celcius[i];
    }
    localSum = max;
    for (int i = 1; i < N-K+1; i++) {
      localSum += celcius[i+K-1] - celcius[i-1];
      max = Math.max(max, localSum);
    }

    System.out.println(max);
  }
}
