package w01;

import java.util.StringTokenizer;

public class Test {
  public static void main(String[] args) {
    // 긴 문자열 생성
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 100000; i++) {
      sb.append("This is a long test string to measure the performance of StringTokenizer and charAt and split methods. ");
    }
    String longString = sb.toString();

    // Measure performance of String.split()
    long startTime = System.currentTimeMillis();
    longString.split(" ");
    long endTime = System.currentTimeMillis();
    long splitDuration = endTime - startTime;

    // Measure performance of StringTokenizer
    startTime = System.currentTimeMillis();
    StringTokenizer tokenizer = new StringTokenizer(longString, " ");
    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken();
    }
    endTime = System.currentTimeMillis();
    long tokenizerDuration = endTime - startTime;

    // Measure performance of charAt + subString
    startTime = System.currentTimeMillis();
    int start = 0;
    for (int i = 0; i < longString.length(); i++) {
      if (longString.charAt(i) == ' ') {
        String token = longString.substring(start, i);
        start = i + 1;
      }
    }
    // 마지막 토큰 처리
    if (start < longString.length()) {
      String token = longString.substring(start);
    }
    endTime = System.currentTimeMillis();
    long substringDuration = endTime - startTime;

    System.out.println("String.split() duration: " + splitDuration + " ms");
    System.out.println("StringTokenizer duration: " + tokenizerDuration + " ms");
    System.out.println("charAt + substring duration: " + substringDuration + " ms");
  }
}