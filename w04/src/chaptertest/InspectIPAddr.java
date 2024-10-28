package chaptertest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InspectIPAddr {
  public static void main(String[] args) throws UnknownHostException {
    // 지시 사항을 참고하여 코드를 작성해 보세요.
    InetAddress inetAddr = InetAddress.getByName("www.elice.io");
    System.out.printf("호스트명: %s\n", inetAddr.getHostName());
    System.out.printf("호스트 IP주소: %s\n", inetAddr.getHostAddress());
  }
}