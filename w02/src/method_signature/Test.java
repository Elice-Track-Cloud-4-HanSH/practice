package method_signature;

import java.util.Arrays;

public class Test {
  private final double PI = 3.14159265358979323846;
  public int calculate(int a, int b) {
    return a + b;
  }

  public double calculate(int x, double y) {
    return x * y;
  }

  public double calculate(double x, int y) {
    return x * y;
  }

  public double calculate(double x, double y) {
    return x * y;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(args));
  }
}
