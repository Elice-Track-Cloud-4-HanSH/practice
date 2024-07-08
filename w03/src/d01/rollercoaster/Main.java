package d01.rollercoaster;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Deque<Integer> deque = new LinkedList<>();
    boolean exitFlag = true;

    while (exitFlag) {
      switch (sc.nextInt()) {
        case -1:
          exitFlag = false;
          break;
        case 0:
          deque.add(sc.nextInt());
          break;
        case 1:
          deque.addFirst(sc.nextInt());
          break;
        case 2:
          deque.removeFirst();
          break;
        default:
          break;
      }
    }
    sc.close();
    for (Integer customer: deque) {
      System.out.print(customer + " ");
    }
    System.out.println();
  }
}
