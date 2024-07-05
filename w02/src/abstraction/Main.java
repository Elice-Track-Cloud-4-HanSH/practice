package abstraction;

public class Main {
  public static void main(String[] args) {
    Dog dog = new Dog();
    dog.eat();

    Cat cat = new Cat();
    cat.eat();

    Person p = new Programmer();
    String[] stacks = ((Programmer)p).getTechStack();
    for (String stack : stacks) {
      System.out.println(stack);
    }
  }
}
