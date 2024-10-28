package main_static;

public class MainStaticUseThisKeyword {
  public static int calculate(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    // error: 'method_signature.Test.this' cannot be referenced from a static context
    // warning: Static member 'main_static.MainStaticUseThisKeyword.calculate(int, int)' accessed via instance reference
//    System.out.println(this.calculate(10,10));
  }
}
