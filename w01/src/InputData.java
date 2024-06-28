import java.util.Scanner;

public class InputData {
  private final Scanner sc = new Scanner(System.in);

  public int getActionNum() {
    int actionNum = -1;
    while (true) {
    System.out.println("액션을 선택해 주세요.\n" +
      "       1. 전투⚔\uFE0F\n" +
      "       2. 포션 먹기\uD83E\uDDEA\n" +
      "       3. 도망\uD83C\uDFC3\u200D");
      actionNum = sc.nextInt();
      if (3 >= actionNum && actionNum >= 1)
        break;

      System.out.println("\uD83D\uDC30 : 올바른 번호를 입력해주세요.");
    }
    return actionNum;
  }

  public int getMenuNum() {
    int menuNum = -1;
    while (true) {
      System.out.println("\uD83D\uDC30 : 계속 모험을 하시겠습니까?\n" +
        "1. 모험 계속 하기⚔\uFE0F \n" +
        "2. 모험 그만 하기\uD83C\uDF33 ");
      menuNum = sc.nextInt();
      if (2 >= menuNum && menuNum >= 1)
        break;

      System.out.println("Invalid menu number.");
    }
    return menuNum;
  }

  public String nextLine() {
    return sc.nextLine();
  }

  public int nextInt() {
    return sc.nextInt();
  }
}
