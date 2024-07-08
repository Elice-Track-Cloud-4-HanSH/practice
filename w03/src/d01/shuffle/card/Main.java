package d01.shuffle.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> deck = new ArrayList<>();
    int idx = 0;
    for (int i = 1; i <= 20; i++) {
      deck.add(i);
    }
    while (true) {
      idx = (int)sc.nextInt();
      if (idx == -1) {
        break;
      }

      int card = (int) deck.remove(idx - 1);
      deck.add(card);
    }
    System.out.println(deck.toString());
  }
}
