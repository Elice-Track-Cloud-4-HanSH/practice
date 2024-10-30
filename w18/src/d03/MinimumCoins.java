package d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int coin100 = N / 100;
        N = N % 100;
        int coin10 = N / 10;
        System.out.println(coin100 + coin10);
    }
}
