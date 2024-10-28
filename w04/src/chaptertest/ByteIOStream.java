package chaptertest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteIOStream {
  public static void main(String[] args) throws IOException {
    String inputData = "I hate test!";
    String inputFilename = "./Test.txt";

    // 지시 사항에 따라 코드를 입력해 보세요.

    File inputFile = new File(inputFilename);
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(inputFile);
    } catch (FileNotFoundException fnfe) {
      inputFile.createNewFile();
      fos = new FileOutputStream(inputFile);
    } finally {
      if (fos != null) {
        System.out.println("파일에 데이터가 성공적으로 입력되었습니다.");
        fos.write(inputData.getBytes());
        fos.close();
      }
    }
  }
}
