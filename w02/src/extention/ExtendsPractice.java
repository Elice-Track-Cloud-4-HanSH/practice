package extention;

abstract class ParentClass {
  abstract void print();
}

interface Interface1 {
  void print();
}

interface Interface2 {
  void print();
}

class SubClass
  extends ParentClass
  implements Interface1, Interface2 {

  @Override
  public void print() {}
}

public class ExtendsPractice {
  public static void main(String[] args) {
    ParentClass p = new SubClass();
    System.out.println("p instanceof ParentClass: " + (p instanceof ParentClass));
    System.out.println("p instanceof Interface1: " + (p instanceof Interface1));
    System.out.println("p instanceof Interface2: " + (p instanceof Interface2));
  }
}