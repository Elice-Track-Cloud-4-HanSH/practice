package main_static;

public class MainStaticNoneStaticFunc {
  public static int calculate(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    // error: Non-static method 'calculate(int, int)' cannot be referenced from a static contex
    System.out.println(calculate(10,10));

    // error: 'method_signature.Test.this' cannot be referenced from a static context
//    System.out.println(this.calculate(10,10));
  }
}
