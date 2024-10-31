package d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin2 {
    static int coin3 = 3;
    static int coin5 = 5;
    static final int MAX = 999_999_999;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < 100_000; i++) {
            test(i);
        }
    }

    public static void test(int N) {
        if (N == 1 || N == 2 || N == 4 || N == 7) {
            System.out.println(-1);
            return;
        }
        if (calc1(N) != calc2(N)) {
            System.out.printf("calc1: %d, calc2: %d%n", calc1(N), calc2(N));
        }
    }

    public static int calc1(int N) {
        int countCoin5 = N / coin5;
        N = N % coin5;

        while (N % coin3 != 0) {
            N += coin5;
            countCoin5--;
        }
        int countCoin3 = N / coin3;
        return countCoin3 + countCoin5;
    }

    public static int calc2(int N) {
        int[] arr = new int[N+1];

        // coin3
        for (int i = 3; i <= N; i++) {
            if (i % coin3 == 0) arr[i] = i / coin3;
        }

        // coin5
        arr[5] = 1;
        for (int i = 6; i <= N; i++) {
            arr[i] = Math.min(arr[i] != 0 ? arr[i] : MAX, arr[i-coin5] != 0 ? arr[i-coin5] + 1 : MAX);
        }

        return arr[N];
    }
}
