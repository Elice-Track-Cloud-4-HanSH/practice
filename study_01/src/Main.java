import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int temp = 0;
    for (int i = 0; i < 3; i++) {
      try {
        temp = Integer.parseInt(br.readLine()) + 3 - i;
      } catch (NumberFormatException e) { }
    }

    if (temp % 15 == 0) {
      System.out.println("FizzBuzz");
    } else if (temp % 3 == 0) {
      System.out.println("Fizz");
    } else if (temp % 5 == 0) {
      System.out.println("Buzz");
    } else {
      System.out.println(temp);
    }
  }
}
