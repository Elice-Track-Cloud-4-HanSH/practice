package chaptertest.manageitem;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
게임 아이템 관리
엘리스는 게임에서 아이템을 관리하는 프로그램을 작성하려고 합니다.
플레이어는 아이템을 얻을 수 있고, 아이템을 사용할 수도 있습니다. 하나의 아이템을 여러 개 가질 수 있으며, 아이템을 사용하면 개수가 하나 줄어듭니다. 아이템의 개수가 0개가 되면, 해당 아이템을 가지고 있지 않다고 간주합니다.
아이템의 사용 기록에는 아이템의 이름과 얻었는지 사용했는지의 기록이 남아 있습니다. 아이템의 이름과 사용 기록을 바탕으로, 플레이어가 현재 가지고 있는 아이템과 개수를 출력하는 프로그램을 작성해 주세요.

지시사항
1. 첫 번째 줄에는 두 개의 정수가 공백을 사이에 두고 주어집니다. 첫 번째 정수 itemCount는 아이템의 종류 수를 의미하며, 두 번째 정수 logCount는 액션 로그에 기록된 행동의 개수를 의미합니다.
2. 그 다음 줄부터 logCount 만큼의 줄이 주어집니다. 각 줄은 아이템의 이름과 액션을 나타내는 문자열이 주어집니다. 액션은 acquire또는 use 중 하나입니다.
3. acquire 액션은 해당 아이템을 획득했음을 나타냅니다. 이 경우, 해당 아이템의 수량을 1 증가시키세요.
4. use 액션은 해당 아이템을 사용했음을 나타냅니다. 이 경우, 해당 아이템의 수량을 1 감소시키세요.
5. 모든 액션을 처리한 후, 가지고 있는 아이템과 각 아이템의 수량을 출력하세요. 아이템은 알파벳 순서로 출력해야 합니다.

입력 예시
3 6
Potion acquire
Sword acquire
Potion use
Shield acquire
Sword use
Shield use

출력 예시
{Potion=0, Shield=0, Sword=0}
 */

public class Main {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int itemCount = scanner.nextInt();
    System.out.println(itemCount);
    int logCount = scanner.nextInt();
    System.out.println(logCount);
    scanner.nextLine();

    // 여기에 코드를 작성해주세요.
    Map<String, Integer> inventory = new TreeMap<>();


    for (int i = 0; i < logCount; i++) {
      String[] event = scanner.nextLine().split(" ");
      if (!inventory.containsKey(event[0])) {
        inventory.put(event[0], 0);
      }
      if (event[1].equals("acquire")) {
        inventory.put(event[0], inventory.get(event[0]) + 1);
      } else {
        inventory.put(event[0], inventory.get(event[0]) - 1);
        if (inventory.get(event[0]) < 0) {
          inventory.put(event[0], 0);
        }

      }
    }

    System.out.println(inventory);

  }
}
