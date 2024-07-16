package innerclass.annonclass;

import java.util.ArrayList;
import java.util.List;

interface Greeting {
  void greet();
}

public class Main {
  public static void main(String[] args) {
    Greeting anonymousGreeting = new Greeting() {
      public static int UUID = 20;
      private static void printDetails() {}
      @Override
      public void greet() {
        System.out.println("Hello from anonymous class!");
      }
    };

    anonymousGreeting.greet();// "Hello from anonymous class!" 출력
  }
}
