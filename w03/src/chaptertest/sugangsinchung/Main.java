package chaptertest.sugangsinchung;

import java.util.*;

/*
수강 신청
하나의 수업을 수강 신청하는 프로그램을 작성하려고 합니다.
수강생은 수업을 신청하며 몇몇 수강생은 신청 버튼을 여러 번 누릅니다. 하나의 수강생이 여러 번 신청하여도 다른 수강생의 자리를 차지할 수는 없습니다.
총 수강생의 수와 수강 신청 기록에 남아있는 수강생의 ID가 순서대로 주어졌을 때, 수강 신청에 성공한 수강생의 ID를 구하는 프로그램을 작성해 주세요.

1. 첫 번째 줄에는 두 개의 정수가 공백을 사이에 두고 주어집니다.
  첫 번째 정수는 수업을 수강할 수 있는 총 수강생의 수입니다.
  두 번째 정수는 수강 신청 로그에 남아있는 수강생 ID의 개수입니다.
2. 두 번째 줄에는 수강생의 ID가 공백을 기준으로 Integer 범위의 양의 정수로 주어집니다. 이는 수강 로그에 남아있는 수강생의 ID를 의미하고, 시간 순서대로 주어집니다.
3. 수강 신청에 성공한 수강생의 ID 목록이 List 형태로 출력됩니다.
 */

public class Main {
  public static void main(String[] args) {
    // 이 곳에 정답 코드를 작성해 주세요.
    Scanner sc = new Scanner(System.in);
    int capacity = sc.nextInt();
    int ids = sc.nextInt();

    boolean[] students = new boolean[ids+1];
    Arrays.fill(students, false);
    List<Integer> signs = new ArrayList<>();

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < ids && signs.size() < capacity; i++) {
      int id = sc.nextInt();

      // set
      set.add(id);

      // memoization
      if (students[id]) continue;
      students[id] = true;
      signs.add(id);
    }

    List<Integer> result = new ArrayList<>(set);
    result.sort(Comparator.naturalOrder());
    System.out.println(result);

    signs.sort(Comparator.naturalOrder());
    System.out.println(signs);
  }
}