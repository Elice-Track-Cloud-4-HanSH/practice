package test.chapter.test6;

class Wizard extends Character {
  // MP 멤버 변수를 추가해 주세요.
  private int MP = 0;

  Wizard(String name) { super(name); }
  Wizard(String name, int AP) { super(name, AP); }
  Wizard(String name, String nickname) { super(name, nickname); }
  Wizard(String name, String nickname, int AP) { super(name, nickname, AP); }

  // getter, setter 메서드를 추가해 주세요.
  public int getMP() { return this.MP; }
  public void setMP(int MP) { this.MP = MP; }

  // attack 메서드를 오버라이딩하여 다시 작성해 주세요.
  public void attack(test.chapter.test5.Character target) {
    super.attack(target);
    if (this.MP == 0) {
      System.out.println(this.name + "의 MP가 모자라 마법 공격을 할 수 없습니다.");
      return;
    }
    target.setHP(target.getHP() - this.MP);
    System.out.println(this.name + "이(가) " + target.getName() + "을(를) 마법의 힘으로 " + this.MP + "만큼 추가 데미지를 입혔습니다!");
  }

  public String toString() {
    String result = "";

    result += "<마법사>\n";
    result += super.toString();

    return result;
  }
}



public class Test6 {
  public static void main(String args[]) {
    Archer archer = new Archer("체셔");
    Wizard wizard = new Wizard("도도새");

    System.out.println(archer);
    System.out.println(wizard);

    wizard.attack(archer);
    wizard.setMP(20);
    wizard.attack(archer);
    System.out.println(archer);
  }
}
