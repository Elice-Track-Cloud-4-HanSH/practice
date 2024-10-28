package d01.byteoutstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
  public static void main(String[] args) throws IOException {
    String inputData = "Hello, Wonder!";
    String inputFilename = "./Hello.txt";

    File file = new File(inputFilename);

    if (!file.exists()) {
      file.createNewFile();
    }

    // 지시 사항에 따라 코드를 입력해 보세요.

    try (FileOutputStream fos = new FileOutputStream(file)) {
      fos.write(inputData.getBytes());

      System.out.println("파일 입력 성공");
    }
    catch (IOException e) {

    }
  }
}