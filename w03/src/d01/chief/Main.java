package d01.chief;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Set<String> works = new HashSet<String>();
    // 이곳에 답안 코드를 작성해 주세요.
    int workCount = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < workCount; i++) {
      works.add(sc.nextLine());
    }
    sc.close();

    System.out.println(works.size());
  }
}
