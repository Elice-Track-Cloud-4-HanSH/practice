package d03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(2001) - 1000); // -1000에서 1000까지의 값 생성
        }

        String data = list.toString().replaceAll(",", "").replace("[", "").replace("]", "");
        System.out.println(data);
    }
}
