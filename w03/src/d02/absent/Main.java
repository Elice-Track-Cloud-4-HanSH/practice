package d02.absent;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 이곳에 답안 코드를 작성해 주세요.
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int hour = sc.nextInt();
    int min = sc.nextInt();
    int sec = sc.nextInt();

    System.out.println(LocalTime.of(hour, min, sec).plusMinutes(N));
  }
}