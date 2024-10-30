package d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxMultipl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().strip().split(" ");
        List<Long> longArr = Arrays.stream(arr).map(Long::parseLong).collect(Collectors.toList());

        longArr.sort(Long::compareTo);

        System.out.println(longArr.get(N - 1) * longArr.get(N - 2));
    }
}
