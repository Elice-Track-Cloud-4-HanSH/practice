package d01.restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Menu {
  static private final Map<String, Integer> menuMap = new HashMap<>();

  static public void execute(int instruction, String key, Integer value) {
    // 이곳에 답안을 작성해 주세요.
    Object costs = 0;
    switch (instruction) {
      case 0:
        menuMap.put(key, value);
        break;
      case 1:
        menuMap.remove(key);
        break;
      case 2:
        costs = menuMap.get(key);
        if (Objects.isNull(costs)) {
          costs = 0;
        }
        System.out.println((int)costs * value);
        break;
      default:
        break;
    }
  }

  private Menu() {}
}
