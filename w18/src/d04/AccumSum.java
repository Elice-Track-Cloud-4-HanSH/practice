package d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AccumSum {
    static long[][] area;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        String[] inputted = br.readLine().split(" ");
        N = Integer.parseInt(inputted[0]);
        M = Integer.parseInt(inputted[1]);
        int K = Integer.parseInt(inputted[2]);

        createMap();
        for (int i = 0; i < K; i++) {
            System.out.println(solution());
        }
    }

    public static void createMap() throws IOException {
        long[][] gnd = new long[N][M];
        area = new long[N][M];
        for (int i = 0; i < N; i++) {
            String[] inputted = br.readLine().split(" ");
            gnd[i] = Arrays.stream(inputted).mapToLong(Long::parseLong).toArray();
        }

        area[0][0] = gnd[0][0];
        for (int c = 1; c < M; c++) {
            area[0][c] = area[0][c-1] + gnd[0][c];
        }

        for (int r = 1; r < N; r++) {
            area[r][0] = area[r-1][0] + gnd[r][0];
        }

        for (int r = 1; r < N; r++) {
            for (int c = 1; c < M; c++) {
                area[r][c] = area[r][c-1] + area[r-1][c] - area[r-1][c-1] + gnd[r][c];
            }
        }
    }

    public static long solution() throws IOException {
        String[] inputted = br.readLine().split(" ");
        int r1 = Integer.parseInt(inputted[0]) - 1;
        int c1 = Integer.parseInt(inputted[1]) - 1;
        int r2 = Integer.parseInt(inputted[2]) - 1;
        int c2 = Integer.parseInt(inputted[3]) - 1;

        // if (r1 == 0 && c1 == 0) {
        //     return area[r2][c2];
        // }
        // if (r1 == 0) {
        //     return area[r2][c2] - area[r2][c1-1];
        // }
        // if (c1 == 0) {
        //     return area[r2][c2] - area[r1-1][c2];
        // }
        // return area[r2][c2] - area[r2][c1-1] - area[r1-1][c2] + area[r1-1][c1-1];

        long total = area[r2][c2];

        long subtractRow = (r1 > 0) ? area[r1-1][c2] : 0;
        long subtractCol = (c1 > 0) ? area[r2][c1-1] : 0;

        long corner = (r1 > 0 && c1 > 0) ? area[r1-1][c1-1] : 0;

        return total - subtractRow - subtractCol + corner;
    }
}
