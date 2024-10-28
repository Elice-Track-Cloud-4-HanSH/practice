package w02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B20920 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // N : 외울 단어의 개수
    // M : 외울 단어의 기준이 되는 길이
    String[] firstLine = br.readLine().split(" ");
    int N = Integer.parseInt(firstLine[0]);
    int M = Integer.parseInt(firstLine[1]);

    Map<String, Integer> map = new HashMap<>();

    // 데이터 전처리
    //  중복된 단어가 있을 수 있으므로 map으로 중복 제거
    //  이렇게 하는 경우, 전체 배열의 길이가 줄어들어 실행시간 증가
    Set<String> wordsSet = new HashSet<>();
    for (int i = 0; i < N; i++) {
      String word = br.readLine().strip();
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    // 정적인 길이가 아니기에 ArrayList를 사용하여 단어를 저장
    List<String> dict = new ArrayList<>();
    for (String word : map.keySet())
      if (word.length() >= M) dict.add(word);

    // 1, 2 if문 : 자주 나오는 단어가 앞으로
    // 3, 4 if문 : 긴 단어가 앞으로
    // 마지막 : 오름차순 정렬
    // sort에 음수가 들어가는 경우 오름차순, 양수가 들어가는 경우 내림차순 정렬
    dict.sort((String o1, String o2) -> {
      if (map.get(o1) > map.get(o2)) return -1;
      if (map.get(o1) < map.get(o2)) return 1;
      if (o1.length() > o2.length()) return -1;
      if (o1.length() < o2.length()) return 1;
      return o1.compareTo(o2);
    });
    // 정렬에 Comparator을 chaining으로 쓰는 경우 timeout 발생!
    // 따라서 정렬 조건에 맞게 하나 하나 적어주자

    StringBuilder sb = new StringBuilder();
    for (String word: dict) sb.append(word).append("\n");
    System.out.print(sb);
  }
}
