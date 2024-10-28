package d01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 유클리드 호제법을 이용한 GCD/LMC 계산
public class GcdLmcCalculator {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        long num1 = Long.parseLong(nums[0]);
        long num2 = Long.parseLong(nums[1]);

        long gcdNum = gcd(num1, num2);
        long lmcNum = num1 * num2 / gcdNum;
        System.out.printf("%d %d\n", gcdNum, lmcNum);
    }

    public static long gcd(long num1, long num2) {
        if (num2 == 0) return num1;
        return gcd(num2, num1 % num2);
    }
}
