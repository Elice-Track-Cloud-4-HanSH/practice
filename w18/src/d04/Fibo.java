package d04;

import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+1];
        arr[1] = arr[2] = 1;
        for (int i = 3; i <= N; i++) arr[i] = arr[i-1] + arr[i-2];
        System.out.println(arr[N]);
    }
}
