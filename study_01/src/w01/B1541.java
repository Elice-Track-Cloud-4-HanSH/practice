package w01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1541 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), "-");

    List<String> strArray = new ArrayList<>();

    while (st.hasMoreTokens()) {
      strArray.add(st.nextToken());
    }

    int result = solution(strArray.remove(0));

    for (String str: strArray) {
      result -= solution(str);
    }

    System.out.println(result);
  }

  public static int solution(String str) {
    StringTokenizer st = new StringTokenizer(str, "+");
    int result = 0;
    while (st.hasMoreTokens()) {
      result += Integer.parseInt(st.nextToken());
    }
    return result;
  }
}
