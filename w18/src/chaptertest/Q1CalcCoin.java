package chaptertest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 엘리스 토끼는 꽉 찬 저금통에 모아둔 동전으로 카페라떼 한 잔을 사러 커피숍에 가려고 한다.
 * 동전의 종류는 N개가 있고, 카페라떼 한 잔의 가격은 M원이다.

 * 엘리스는 무거운 동전 주머니를 가지고 다니기 힘들기 때문에, 최소한의 동전 개수만을 사용하여
 * M원에 딱 맞춰 계산하려고 한다.
 * 이때, 필요한 동전의 최소 개수를 구하여라.
 * 단, 저금통에는 각 종류의 동전이 무수히 많다고 가정한다.
 *
 */

/*
// 입력 1
7 45
42
10
40
8
32
24
9

// 출력 1
5
 */

/*
// 입력 2
9 548
27
449
99
419
437
214
287
378
20

//출력 2
2
 */

public class Q1CalcCoin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[50001];
        Arrays.fill(arr, 50001);

        String[] inputtedArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputtedArr[0]);
        int M = Integer.parseInt(inputtedArr[1]);

        int val;
        for (int i = 0; i < N; i++) {
            val = Integer.parseInt(br.readLine());
            arr[val] = 1;
            for (int coin = val + 1; coin <= M; coin++) {
                arr[coin] = Math.min(arr[coin], arr[coin - val] + 1);
            }
        }

        System.out.println(arr[M]);
    }
}
