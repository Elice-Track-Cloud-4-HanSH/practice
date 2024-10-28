package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15649 {
  // 해당 숫자가 이미 배열에 존재하는지 확인
  // set → toList → sort, list.exists() → list.append() 보다 더 빠름
  // 이것을 "메모이제이션"이라고 부른다
  static int[] check;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputed= br.readLine().split(" ");
    // N : n까지의 수
    // M : 만들어야할 수열의 길이
    int N = Integer.parseInt(inputed[0]);
    int M = Integer.parseInt(inputed[1]);

    // arr을 static global variable로 설정하면
    // 매개변수로 넣어줄 필요가 없다.
    int[] arr = new int[M];
    check = new int[N+1];
    calc(arr, 0, M, N);
  }

  public static void calc(int[] arr, int curIdx, int maxIdx, int maxNum) {
    if (curIdx == maxIdx) {
      StringBuilder sb = new StringBuilder();
      for (int data : arr) {
        // printf로 하나 하나 찍는 경우 timeout 발생
        // 따라서 StringBuilder로 한번에 출력
        sb.append(data).append(" ");
      }
      System.out.println(sb);
      return;
    }
    for (int i = 1; i <= maxNum; i++) {
      if (check[i] == 1) continue;
      arr[curIdx] = i;
      // 해당 숫자가 사용중임을 알리는 flag 설정
      check[i] = 1;
      // 재귀호출
      calc(arr, curIdx+1, maxIdx, maxNum);
      // 해당 숫자를 사용 완료했다는 flag 설정
      check[i] = 0;
    }
  }
}
