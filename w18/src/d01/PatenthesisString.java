package d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PatenthesisString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;

        String s = br.readLine().strip();

        for (char t : s.toCharArray()) {
            if (t == '(') {
                cnt++;
            }
            else {
                if (cnt == 0) {
                    sayNo();
                }
                cnt--;
            }
        }
        if (cnt > 0) sayNo();

        System.out.println("YES");
    }

    private static void sayNo() {
        System.out.println("NO");
        System.exit(0);
    }
}
