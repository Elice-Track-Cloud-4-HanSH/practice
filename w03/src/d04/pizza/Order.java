package d04.pizza;

public class Order {
  private static final int MAX_CHEESE_ALLOWED = 1000;

  public void orderCheesePizza(int i) throws ExcessiveCheeseException {
    if (i > MAX_CHEESE_ALLOWED) throw new ExcessiveCheeseException(i, MAX_CHEESE_ALLOWED, "주문 가능한 치즈의 양을 초과하였습니다.");
  }

  // 지시 사항을 참고하여 코드를 작성해 보세요.

}
