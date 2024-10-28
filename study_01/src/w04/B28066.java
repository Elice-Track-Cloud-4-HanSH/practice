package w04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
  int squirrelNum;
  Node next;
}

public class B28066 {
  static Node head;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputted = br.readLine().split(" ");
    int N = Integer.parseInt(inputted[0]);
    int K = Integer.parseInt(inputted[1]);

    makeLinkedList(N);
    System.out.println(solution(N, K));
  }

  static void makeLinkedList(int N) {
    head = new Node();
    head.squirrelNum = 1;
    head.next = head;

    for (int i = 2; i <= N; i++) {
      Node squirrel = new Node();
      squirrel.squirrelNum = i;
      squirrel.next = head.next;
      head.next = squirrel;
      head = head.next;
    }
    head = head.next;
  }

  static int solution(int N, int K) {
    while (N >= K) {
      for (int i = 0; i < K-1; i++) {
        head.next = head.next.next;
      }
      head = head.next;
      N -= K-1; // 사라지는 청설모는 K-1마리
                // 첫 번째 청설모는 살아남음, 두 번째 청설모부터 K 번째 청설모까지 사라짐
    }
    return head.squirrelNum;
  }
}
