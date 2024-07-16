package d04.onlineshopping;

class OutOfStockException extends Exception {
  public OutOfStockException(String message) {
    super(message);
  }
}

public class Main {
  public static void main(String[] args) {
    // 테스트를 위한 코드입니다. 변경하지 마세요.
    Product product = new Product("텀블러", 0);
    // 지시 사항을 참고하여 코드를 작성해 보세요.
    try {
      addProductToCart(product);
    } catch (OutOfStockException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("장바구니 업데이트를 시도했습니다.");
    }

  }

  static void addProductToCart(Product product) throws OutOfStockException {
    // 지시 사항을 참고하여 코드를 작성해 보세요.
    if (product.getStock() == 0) throw new OutOfStockException("상품 " + product.getName() + "은/는 재고가 없습니다.");
  }
}