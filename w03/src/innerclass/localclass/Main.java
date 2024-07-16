package innerclass.localclass;

import java.time.LocalTime;

class OuterClass {
  void outerMethod() {
    final int localVar = 30;

    class LocalInnerClass {
      static int uuid = 20;
      static void printDetails() {}
      void accessLocalVar() {
        System.out.println(localVar);
      }
    }

    LocalInnerClass local = new LocalInnerClass();
    local.accessLocalVar();// 30 출력
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass outer = new OuterClass();
    outer.outerMethod();

    LocalTime lt = LocalTime.of(23, 59, 23).plusMinutes(30);
    System.out.println(lt.plusMinutes(30));
  }
}
