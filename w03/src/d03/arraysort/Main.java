package d03.arraysort;

import java.util.*;


public class Main {

  public static List<String> sortList(List<String> inputList) {
    // 지시 사항을 참고하여 코드를 구현해 보세요.
//    Collections.sort(inputList, new Comparator<String>() {
//      @Override
//      public int compare(String o1, String o2) {
//        String s1 = o1.toLowerCase();
//        String s2 = o2.toLowerCase();
//        return s1.compareTo(s2);
//      }
//    });
//    return inputList;

//    inputList.sort((o1, o2) -> {
//      String s1 = o1.toLowerCase();
//      String s2 = o2.toLowerCase();
//      return s1.compareTo(s2);
//    });
//    return inputList;
    int[][] targets = { {4,5} , {4,8}, {10,14}, {11,13}, {5,12}, {3,7}};
    Arrays.sort(targets, Comparator.comparingInt(o -> (o[1] - o[0])));
    System.out.println(targets[0][0]);

    Collections.sort(inputList, String::compareToIgnoreCase);
//    inputList.sort(String::compareToIgnoreCase);
    return inputList;
  }

  public static void main(String[] args) {
    // 테스트를 위한 문자열 리스트 초기화
    List<String> names = Arrays.asList("Steve", "Rachel", "Mike", "peter", "anna");

    // sortList 메서드를 호출하여 리스트를 정렬하세요.
    List<String> strings = sortList(names);

    // 정렬된 리스트를 출력하세요.
    System.out.println(strings);

  }
}
