package abstraction;

public class Programmer extends Person implements Programmable, Debuggable {
  @Override
  public void doDebugging() {
    System.out.println("Doing debugging...");
  }

  @Override
  public String[] getTechStack() {
    return Programmable.teckStack;
  }

  @Override
  public void doProgramming() {
    System.out.println("Doing programming...");
  }
}
