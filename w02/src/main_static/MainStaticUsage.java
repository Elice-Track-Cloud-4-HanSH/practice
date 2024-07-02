package main_static;

public class MainStaticUsage {
  public static int calculate(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    System.out.println(calculate(10,10));
    System.out.println(MainStaticUseThisKeyword.calculate(10,10));
    System.out.println(main_static.MainStaticUseThisKeyword.calculate(10,10));
  }
}
