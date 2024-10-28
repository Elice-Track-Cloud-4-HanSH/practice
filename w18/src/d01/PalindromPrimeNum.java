package d01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PalindromPrimeNum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int counts = Integer.parseInt(br.readLine());
        int result = 0;

        List<String> strs = new ArrayList<>();

        for (int i = 0; i < counts; i++) {
            strs.add(br.readLine().trim());
        }
        br.close();

        // 원래라면 소수 검사 후 문자열 검사하는 것이 더 좋지만
        // 지금은 N이 최대 9자리밖에 나오지 않는다!
        // 즉 문자열의 자리 비교는 최대 4번밖에 나오지 않는다는 말
        // 하지만 소수 체크는 최대 31,622번을 해야한다.
        // root 계산을 했지만 이는 2에 비하면 매우 큰 값.
        // 따라서 회문을 먼저 체크하고 소수인지를 판별하자

        // 에라토스테네스의 체를 이용하면 좋겠지만, 시간이 너무 오래 걸린다!
        // 소수가 아닌 수를 건너뛴다면 O(N log N) 시간이 줄어들지만 몇만단위이다.
        // 단순히 palindrome을 검사 후 소수를 for문으로 검사하는 것이 더 좋을지,
        // 에라토스테네스의 체를 미리 만들어놓고 소수 판별할지는 고민해야할 문제
        for (String s : strs) {
            // check palindrome
            int length = s.length();
            boolean isSkip = false;
            for (int i = 0; i < length / 2; i++) {
                if (s.charAt(i) != s.charAt(length-1 - i)) {
                    isSkip = true;
                    break;
                }
            }
            if (isSkip) continue;

            // check prime num
            isSkip = false;
            int num = Integer.parseInt(s);
            if (num == 1) continue;
            for (int i = 2; i <= (int)Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isSkip = true;
                    break;
                }
            }
            if (isSkip) continue;

            result++;
        }

        System.out.println(result);
    }
}
