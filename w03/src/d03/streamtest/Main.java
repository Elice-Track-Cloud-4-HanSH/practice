package d03.streamtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product {

  private String name;
  private int price;

  Product(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() { return this.name; }
  public int getPrice() { return this.price; }
}


class Order {

  private List<Product> itemList = new ArrayList<>();

  public void addItem(Product product) {
    this.itemList.add(product);
  }

  public List<Product> getItemList() { return this.itemList; }
}

class Member {

  private List<Order> orders;
  private String name;
  private int age;

  public Member(String name, int age) {
    this.orders = new ArrayList<>();
    this.name = name;
    this.age = age;
  }

  public void addOrder(Order order) {
    this.orders.add(order);
  }

  public List<Order> getOrders () { return this.orders; }
}

public class Main {
  public static void main(String[] args) {
    //given
    Member choi = new Member("choi", 28);
    Member woo = new Member("woo", 25);

    Product tv = new Product("TV", 300_000);
    Product airConditioner = new Product("에어컨", 200_000);
    Product refrigerator = new Product("냉장고", 500_000);
    Product phone = new Product("핸드폰", 100_000);

    Order order1 = new Order();
    order1.addItem(tv);
    order1.addItem(airConditioner);
    order1.addItem(refrigerator);

    Order order2 = new Order();
    order2.addItem(refrigerator);
    order2.addItem(phone);

    choi.addOrder(order1);
    woo.addOrder(order2);

    List<Member> members = Arrays.asList(choi, woo);

    //when
    int totalPrice = members.stream()
              .flatMap(m -> m.getOrders().stream())
              .flatMap(o -> o.getItemList().stream())
              .mapToInt(Product::getPrice)
              .sum();

    //then
    long expect = tv.getPrice() + airConditioner.getPrice() + refrigerator.getPrice() + phone.getPrice();
    System.out.println(expect + " " + totalPrice);
  }
}
