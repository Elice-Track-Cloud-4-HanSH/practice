package w01;

import java.util.Scanner;

// 단순 계산 - 터렛

public class B1002 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x1, y1, x2, y2, r1, r2;
    for (int i = 0; i < n; i++) {
      x1 = sc.nextInt();
      y1 = sc.nextInt();
      r1 = sc.nextInt();
      x2 = sc.nextInt();
      y2 = sc.nextInt();
      r2 = sc.nextInt();

      double rad = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
      if (rad == 0 && r1 == r2) {
        System.out.println(-1);
      } else if (rad < Math.abs(r1-r2)) {
        System.out.println(0);
      } else if (rad == Math.abs(r1-r2)) {
        System.out.println(1);
      } else if (rad < r1 + r2) {
        System.out.println(2);
      } else if (rad == r1 + r2) {
        System.out.println(1);
      } else if (rad > r1 + r2) {
        System.out.println(0);
      }
    }
  }
}