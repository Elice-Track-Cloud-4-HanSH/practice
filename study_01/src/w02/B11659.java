package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputted = br.readLine().split(" ");

    int N = Integer.parseInt(inputted[0]);
    int M = Integer.parseInt(inputted[1]);

    int i = 1;
    // 누적합을 이용하여 처음 계산에만 O(1)을 만들어보자! → 전체는 O(k)
    int[] datas = new int[N+1];
    int[] accumSum = new int[N+1];
    inputted = br.readLine().split(" ");
    for (String num : inputted) {
      datas[i] = Integer.parseInt(num);
      accumSum[i] = accumSum[i-1] + datas[i];
      i++;
    }

    // 일반적인 for 사용 시 O(N)의 시간 복잡도 → 전체는 O(Nk)
    // O(1)을 요구한다.
    for (i = 0; i < M; i++) {
      inputted = br.readLine().split(" ");
      int start = Integer.parseInt(inputted[0]);
      int end = Integer.parseInt(inputted[1]);
      System.out.println(accumSum[end] - accumSum[start-1]);
    }
  }
}
