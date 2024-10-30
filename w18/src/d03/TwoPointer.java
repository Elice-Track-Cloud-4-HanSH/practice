package d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class InputtedValue {
    int N;
    int M;
    List<Long> list;
}

public class TwoPointer {
    public static void main(String[] args) throws IOException {
        twoPointer();
        windowedTwoPointer();
    }

    private static InputtedValue getValues() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputtedValue values = new InputtedValue();

        String[] inputted = br.readLine().strip().split(" ");
        values.N = Integer.parseInt(inputted[0]);
        values.M = Integer.parseInt(inputted[1]);

        inputted = br.readLine().strip().split(" ");
        values.list = Arrays.stream(inputted).map(Long::parseLong).collect(Collectors.toList());

        return values;
    }

    private static void twoPointer() throws IOException {
        InputtedValue value = getValues();
        long startTime;

        startTime = System.currentTimeMillis();
        optimized(value.list, value.N, value.M);
        System.out.println("optimized: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        unOptimized(value.list, value.N, value.M);
        System.out.println("unoptimized: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    private static void optimized(List<Long> list, int N, int M) {
        int cnt = 0;
        int left = 0, right = 0;
        long localSum = 0;

        // stream으로 계산할 수 있지만 굳이...?
        for (int i = left; i <= right; i++) {
            localSum += list.get(i);
        }

        while (left != N && right < N) {
            if (localSum == M) {
                cnt++;
                right++;
                if (right == N) break;
                localSum += list.get(right);
            }
            else if (localSum > M) {
                localSum -= list.get(left);
                left++;
            } else {
                right++;
                if (right == N) break;
                localSum += list.get(right);
            }
        }

        System.out.println(cnt);
    }

    private static void unOptimized(List<Long> list, int N, int M) {
        int cnt = 0;
        int left = 0, right = 0;

        while (left != N && right < N) {
            int localSum = 0;
            for (int i = left; i <= right; i++) {
                localSum += list.get(i);
            }

            if (localSum == M) {
                cnt++;
                right++;
            }
            else if (localSum > M) {
                left++;
            } else {
                right++;
            }
        }

        System.out.println(cnt);
    }

    private static void windowedTwoPointer() throws IOException {
        InputtedValue value = getValues();
        long startTime;

        startTime = System.currentTimeMillis();
        windowedOptimized(value.list, value.N, value.M);
        System.out.println("optimized: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        windowedUnOptimized(value.list, value.N, value.M);
        System.out.println("unoptimized: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    private static void windowedOptimized(List<Long> list, int N, int M) {
        int left = 0, right = left + M;
        long localSum = 0;
        for (int i = left; i < right; i++) {
            localSum += list.get(i);
        }
        long max = localSum;
        while (right != N) {
            localSum = localSum - list.get(left) + list.get(right);
            left++;
            right++;
            max = Math.max(max, localSum);
        }

        System.out.println(max);
    }

    private static void windowedUnOptimized(List<Long> list, int N, int M) throws IOException {

        int left = 0, right = left + M;

        long max = 0;
        while (right != N + 1) {
            long localSum = 0;
            for (int i = left; i < right; i++) {
                localSum += list.get(i);
            }
            left++;
            right++;
            max = Math.max(max, localSum);
        }

        System.out.println(max);
    }
}
