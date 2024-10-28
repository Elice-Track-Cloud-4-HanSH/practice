package d01.readfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    String inputFilename = "./asdf.txt";
    try {
      System.out.println("파일 내용: " + readFileContent(inputFilename));
    } catch (IOException _) {
    }
  }

  public static String readFileContent(String inputFilename) throws IOException {
    // 지시 사항에 따라 코드를 작성해 보세요.
    StringBuilder sb = new StringBuilder();
    try (FileInputStream fis = new FileInputStream(inputFilename)) {
      while (fis.available() > 0) {
        sb.append((char)fis.read());
      }
      return sb.toString();
    } catch (IOException ioe) {
      ioe.printStackTrace();
      throw new IOException();
    }
  }
}
