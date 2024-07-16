package chaptertest.shoppinglist;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
** 쇼핑 목록 관리
* 엘리스는 쇼핑 앱을 개발하고 있습니다. 이 앱은 사용자가 쇼핑 목록에 아이템을 추가하고 삭제하는 기능을 제공합니다.
* 사용자는 아이템을 여러 번 추가할 수 있지만, 한 번에 하나씩만 삭제할 수 있습니다. 삭제는 항상 최근에 추가된 아이템 순서로 이루어집니다. 즉, 마지막에 추가된 아이템이 가장 먼저 삭제됩니다.
*
* 지시사항
* 첫 번째 줄에는 두 개의 정수가 공백을 사이에 두고 주어집니다. 첫 번째 정수는 쇼핑 아이템의 종류의 수를 의미하며, 두 번째 정수는 쇼핑 이벤트의 수를 의미합니다.
* 두 번째 줄부터는 쇼핑 이벤트가 시간 순서대로 주어집니다. 이벤트는 add [아이템 이름]또는 remove입니다. add [아이템 이름]이벤트는 해당 아이템을 쇼핑 목록에 추가합니다. remove이벤트는 가장 최근에 추가된 아이템을 쇼핑 목록에서 삭제합니다.
* 모든 이벤트가 처리된 후에는 쇼핑 목록에 남아 있는 아이템을 출력합니다. 아이템은 추가된 순서대로 출력합니다.

* 입력 예시
5 6
add Apple
add Banana
remove
add Grape
add Apple
remove

* 출력 예시
Apple
Grape
*/
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int kinds = sc.nextInt();
    int events = sc.nextInt();
    sc.nextLine();

    List<String> ls = new LinkedList<>();

    for (int i = 0; i < events; i++) {
      String[] commands = sc.nextLine().split(" ");
      if (commands.length == 2) {
        ls.add(commands[1]);
      } else {
        ls.removeLast();
      }
    }

    ls.forEach(System.out::println);
  }
}
