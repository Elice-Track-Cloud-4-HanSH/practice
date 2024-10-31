package d04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random rand = new Random();
        int row = 438;
        int col = 723;
        int k = 40;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write(String.format("%d %d %d", row, col, k));
            writer.newLine();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    writer.write(String.format("%d ", rand.nextInt(1_000) + 1));
                }
                writer.newLine();
            }

            int r1, r2, c1, c2;
            int temp;
            for (int i = 0; i < k; i++) {

                r1 = rand.nextInt(row) + 1;
                do {
                    r2 = rand.nextInt(row) + 1;
                } while (r1 == r2);

                if (r1 > r2) {
                    temp = r1;
                    r1 = r2;
                    r2 = temp;
                }

                c1 = rand.nextInt(col) + 1;
                do {
                    c2 = rand.nextInt(col) + 1;
                } while (c1 == c2);

                if (c1 > c2) {
                    temp = c1;
                    c1 = c2;
                    c2 = temp;
                }

                writer.write(String.format("%d %d %d %d", r1, c1, r2, c2));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
