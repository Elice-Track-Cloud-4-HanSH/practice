package w02;

import java.io.*;

public class B11723_1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(br.readLine());

    int S = 0;

    for (int i = 0; i < M; i++) {
      String[] inputted = br.readLine().split(" ");

      if (inputted[0].equals("add")) {
        S |= 1 << Integer.parseInt(inputted[1]);
        continue;
      }
      if (inputted[0].equals("remove")) {
        S &= ~(1 << Integer.parseInt(inputted[1]));
        continue;
      }
      if (inputted[0].equals("check")) {
        bw.write((S & (1 << Integer.parseInt(inputted[1]))) == 0 ? 0 : 1);
        bw.write("\n");
        continue;
      }
      if (inputted[0].equals("toggle")) {
        S ^= 1 << Integer.parseInt(inputted[1]);
        continue;
      }
      if (inputted[0].equals("all")) {
        S = Integer.MAX_VALUE;
        continue;
      }
      if (inputted[0].equals("empty")) {
        S = 0;
      }
    }
  }
}
