package d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Z {
    static int R;
    static int C;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> inputted = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();

        int N = inputted.get(0);
        R = inputted.get(1);
        C = inputted.get(2);

        z(1 << N, 0, 0);
    }

    public static void z(int n, int r, int c) {
        if (r == R && c == C) {
            System.out.println(result);
            return;
        }

        if (!((r <= R && R < r + n) && (c <= C && C < c + n))) {
            result += n * n;
            return;
        }

        z(n/2, r, c);
        z(n/2, r, c + n/2);
        z(n/2, r + n/2, c);
        z(n/2, r + n/2, c + n/2);
    }
}
