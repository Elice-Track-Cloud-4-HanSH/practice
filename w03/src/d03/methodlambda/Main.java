package d03.methodlambda;

@FunctionalInterface
interface Function {
  void apply();
}

public class Main {
  public static void main(String[] args) {
    Function f = () -> System.out.println("123");
  }
}