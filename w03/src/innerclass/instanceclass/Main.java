package innerclass.instanceclass;

class OuterClass {
  private int outerField = 10;
  public static int UUID = 20;

  class InstanceInnerClass {
    private static int UUID = 30;
    void accessOuterField() {
      System.out.println(outerField);
    }
    private static void printOuterField() {}
  }
}

public class Main {
  public static void main(String[] args) {
    System.out.println(OuterClass.UUID);
    OuterClass outer = new OuterClass();
    OuterClass.InstanceInnerClass inner = outer.new InstanceInnerClass();
    inner.accessOuterField();// 10 출력
  }
}
