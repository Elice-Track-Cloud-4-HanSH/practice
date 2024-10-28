package w01;

import java.io.*;
import java.util.*;

public class LongLongInput {
  public static void main(String[] args) throws IOException {
    // 긴 문자열 생성
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 1000000; i++) {
      sb.append("This is a long test string to measure the performance of Scanner and BufferedReader. ");
    }
    String longString = sb.toString();

    // 파일로 저장
    FileWriter writer = new FileWriter("test.txt");
    writer.write(longString);
    writer.close();
  }
}
