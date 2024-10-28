package abstraction.testing;

interface Animal {
  default void makeSound() {
    System.out.println("some sound...");
  }
}

//abstract class Cat {
//  default void makeSound() {
//    System.out.println("meow");
//  }
//}

// Complile ERROR
class Lion implements Animal  {}

public class Main {
  String t = "asdf";
  public static void main(String[] args) {
    Lion lion = new Lion();
    Lion baby = new Lion();
    lion.makeSound();
    System.out.println(lion.equals(baby));
    System.out.println(lion == baby);

  }
}