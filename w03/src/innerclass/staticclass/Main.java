package innerclass.staticclass;

class OuterClass {
  private static int staticOuterField = 20;
  private int UUID = 20;

  static class StaticInnerClass {
    void accessStaticOuterField() {
      System.out.println(staticOuterField);
    }
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass.StaticInnerClass inner = new OuterClass.StaticInnerClass();
    inner.accessStaticOuterField();// 20 출력
  }
}