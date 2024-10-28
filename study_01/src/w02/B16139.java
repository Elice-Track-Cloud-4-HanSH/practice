package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B16139 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Character, List<Integer>> map = new HashMap<>();

    String origin = br.readLine().strip();
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < origin.length(); i++) {
      char ch = origin.charAt(i);
      if (!map.containsKey(ch)) {
        map.put(ch, new ArrayList<>());
      }
      map.get(ch).add(i);
    }

    System.out.println(map);

    String[] inputted;
    for (int loop = 0; loop < N; loop++) {
      inputted = br.readLine().strip().split(" ");

      List<Integer> idxs = map.get(inputted[0].charAt(0));
      if (idxs == null) {
        System.out.println(0);
        continue;
      }

      // 하나의 캐릭터의 인덱스가 담긴 idxs를 돌며
      // 해당 인덱스 사이에는 몇 개가 있는지 확인
      int l = Integer.parseInt(inputted[1]);
      int r = Integer.parseInt(inputted[2]);
      int counts = 0;
      for (int idx : idxs) {
        if (r < idx) break;
        if (l <= idx) counts++;
      }
      System.out.println(counts);
    }
  }
}
