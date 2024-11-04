package d04;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Permuitation {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[nums[0] + 1];
        Arrays.fill(visited, false);

        permutate(nums[0], nums[1], 0, "");
    }

    public static void permutate(int maxN, int m, int cnt, String result) {
        if (cnt == m) {
            System.out.println(result);
            return;
        }

        for (int i = 1; i <= maxN; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutate(maxN, m, cnt+1, result + i + " ");
                visited[i] = false;
            }
        }
    }
}
