package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16139_1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String origin = br.readLine().strip();
    int N = Integer.parseInt(br.readLine());

    int strLen = origin.length();
    int[][] idxs = new int[26][strLen+1];
    idxs[origin.charAt(0) - 'a'][1] = 1;
    for (int i = 1; i < strLen; i++) {
      int ch = origin.charAt(i) - 'a';
      for (int j = 0; j < 26; j++) {
        idxs[j][i+1] = idxs[j][i];
      }
      idxs[ch][i+1] += 1;
    }

    String[] inputted;
    for (int loop = 0; loop < N; loop++) {
      inputted = br.readLine().split(" ");

      int ch = inputted[0].charAt(0) - 'a';
      int l = Integer.parseInt(inputted[1]);
      int r = Integer.parseInt(inputted[2]);

      System.out.println(idxs[ch][r+1] - idxs[ch][l]);
    }
  }
}
