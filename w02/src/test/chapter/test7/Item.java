package test.chapter.test7;

abstract public class Item {
  private String name;
  private String description;

  public Item(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() { return this.name; }
  abstract public void use(Character character);
  public String toString() {
    String str = "";
    str += "====================\n" +
              "아이템 설명\n" +
              "이름: " + this.name + "\n" +
              "설명: " + this.description + "\n" +
              "====================\n";
    return str;
  }
}
