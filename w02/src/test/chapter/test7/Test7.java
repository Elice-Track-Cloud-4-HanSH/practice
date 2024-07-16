package test.chapter.test7;

import java.util.ArrayList;
import java.util.List;

public class Test7 {
  public static void main(String args[]) {
    Warrior warrior = new Warrior("캐터필러", "Caterpillar", 30);
    Item exampleItem = new Item("예시 아이템", "아이템 객체 사용 예시입니다.") {
      public void use(Character character) {
        System.out.println("아이템 사용!");
      }
    };

    List<Number> t = new ArrayList<>();
    t.remove()

    System.out.println(exampleItem);

    warrior.addItem(exampleItem);
    System.out.println(warrior);

    warrior.useItem(exampleItem);
    System.out.println(warrior);
  }
}
