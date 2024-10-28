package w02;

import java.io.*;

public class B9935 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine().strip();
    String bomb = br.readLine().strip();
    int bombLength = bomb.length();

    StringBuilder sb = new StringBuilder(str);

    int endIdx = 0;
    int idx = 0;
    while (true) {
      if (idx == sb.length()) break;
      int i = 0;
      if (sb.charAt(idx) == bomb.charAt(i)) {
        endIdx = idx;
        while (sb.charAt(endIdx) == bomb.charAt(i++)) {
          endIdx++;
          if (i == bombLength) break;
        }
        if (endIdx - idx == bombLength) {
          sb.delete(idx, endIdx);
          idx = Math.max(idx - bombLength, -1);
        }
      }
      idx++;
    }

    System.out.println(sb.length() == 0 ? "FRULA\n" : sb.toString() + "\n");
  }
}
