package d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 실습1과 실습2는 수 범위의 문제라 따로 추가하지는 않음
public class PrimeCalculator {
    public static String EVEN = "Even";
    public static String ODD = "Odd";

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

    }

    public static void primeNumIsOddOrEven() throws IOException {
        int repeat = Integer.parseInt(br.readLine());
        for (int r = 0; r < repeat; r++) {
            int inputVal = Integer.parseInt(br.readLine());
            int sqrtVal = (int) Math.sqrt(inputVal);

            System.out.println(inputVal == (int)Math.pow(sqrtVal, 2) ? ODD : EVEN);
        }
    }

    public static void getPrimeNumCount() throws IOException {
        int num = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 2; i <= num; i++) {
            int t = (int)Math.sqrt(i);
            boolean isSkip = false;
            for (int j = 2; j <= t; j++) {
                if (i % j == 0) {
                    isSkip = true;
                    break;
                }
            }
            if (!isSkip) result++;
        }
        System.out.println(result);
    }
}
