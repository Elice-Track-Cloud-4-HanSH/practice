package d01.restaurant;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int numberOfInstruction = sc.nextInt();

    Stack<Integer> stack = new Stack<>();

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(numberOfInstruction);

    for (int i = 0; i < numberOfInstruction; i++) {
      int instruction = sc.nextInt();
      String key = sc.next();
      int value = sc.nextInt();

      Menu.execute(instruction, key, value);
    }
  }
}