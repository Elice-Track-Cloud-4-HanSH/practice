package d01.byteoutstream.image;

import javax.print.attribute.standard.Destination;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {

    String sourceFilePath = System.getProperty("user.dir") + "/image.png";
    String destinationFilePath = System.getProperty("user.dir") + "/copied-image.png";


    // 지시 사항을 참고하여 코드를 작성해 보세요.

    try (
      FileInputStream fis = new FileInputStream(new File(sourceFilePath));
      FileOutputStream fos = new FileOutputStream(new File(destinationFilePath))
    ) {
      fos.write(fis.readAllBytes());
    }
  }
}

