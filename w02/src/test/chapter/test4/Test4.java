package test.chapter.test4;

interface PowerControl {
  public String turnOn();
  public String turnOff();
}

class Tv implements PowerControl {

  @Override
  public String turnOn() {
    return "티비를 켭니다.";
  }

  @Override
  public String turnOff() {
    return "티비를 끕니다.";
  }
}

class Computer implements PowerControl {

  @Override
  public String turnOn() {
    return "컴퓨터를 켭니다.";
  }

  @Override
  public String turnOff() {
    return "컴퓨터를 끕니다.";
  }
}

class Ac implements PowerControl {

  @Override
  public String turnOn() {
    return "에어컨을 켭니다.";
  }

  @Override
  public String turnOff() {
    return "에어컨을 끕니다.";
  }
}

public class Test4 {
  public static void main(String args[]) {

    Tv tv = new Tv();
    Computer computer = new Computer();
    Ac ac = new Ac();

    System.out.println(tv.turnOn());
    System.out.println(tv.turnOff());
    System.out.println(computer.turnOn());
    System.out.println(computer.turnOff());
    System.out.println(ac.turnOn());
    System.out.println(ac.turnOff());

  }
}
