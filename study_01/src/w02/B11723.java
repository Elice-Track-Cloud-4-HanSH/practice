package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11723 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());

    int[] S = new int[21];

    for (int i = 0; i < M; i++) {
      String[] inputted = br.readLine().split(" ");

      if (inputted[0].equals("add")) {
        S[Integer.parseInt(inputted[1])] = 1;
        continue;
      }
      if (inputted[0].equals("remove")) {
        S[Integer.parseInt(inputted[1])] = 0;
        continue;
      }
      if (inputted[0].equals("check")) {
        System.out.println(S[Integer.parseInt(inputted[1])]);
        continue;
      }
      if (inputted[0].equals("toggle")) {
        S[Integer.parseInt(inputted[1])] = S[Integer.parseInt(inputted[1])] == 1 ? 1 : 0;
        continue;
      }
      if (inputted[0].equals("all")) {
        Arrays.fill(S, 1);
        continue;
      }
      if (inputted[1].equals("remove")) {
        Arrays.fill(S, 0);
        continue;
      }
    }
  }
}
