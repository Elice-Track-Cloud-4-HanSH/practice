package d03.stringmodify;

import java.util.StringTokenizer;

@FunctionalInterface
interface StringTransformer {
  // 지시사항을 참고하여 코드를 작성해 보세요.
  public String transform(String s);
}

public class Main {
  // 지시사항을 참고하여 코드를 작성해 보세요.
  public static StringTransformer toUpperCaseTransformer = (s) -> {return s.toUpperCase();};
  public static StringTransformer removeSpacesTransformer = (s) -> {
    String res = "";
    StringTokenizer st = new StringTokenizer(s, " ");
    while (st.hasMoreTokens()) {
      res += st.nextToken();
    }
    return res;
  };
  public static StringTransformer addAsteriskTransformer = (s) -> {
    return "*" + s.trim() + "*";
  };

  public static void main(String[] args) {
    String inputString = " Hello, Functional Interface! ";

    System.out.println("대문자 변환 후: " + toUpperCaseTransformer.transform(inputString));
    System.out.println("공백 제거 후: " + removeSpacesTransformer.transform(inputString));
    System.out.println("\"*\" 기호 추가 후: " + addAsteriskTransformer.transform(inputString));
  }
}
