package chaptertest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 서울 선릉에는 수많은 빌딩들이 있다.
 * 엘리스 토끼는 선릉에서 일렬로 세워진 빌딩들을 보았다.
 * 하지만, 일렬로 세워진 빌딩을 옆에서 보니, 일부 빌딩들만 보인다는 것을 깨달았다.
 * 일렬로 세워진 빌딩들의 개수와 높이 정보가 주어질 때, 엘리스 토끼가 이 빌딩들을 옆에서 본다면, 몇 개의 빌딩들만이 보이게 될지 알아보자.
 * 왼쪽에서 보게 될 빌딩의 수와 오른쪽에서 보게 될 빌딩의 수를 공백으로 구분하자
 */

/*
입력 1
4
1 4 3 2

출력 1
2 3
 */

/*
입력 2
5
5 4 3 2 1

출력 2
1 5
 */
public class Q2Building {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int fromLeft = 0, fromRight = N-1;
        int fromLeftResult = 1, fromRightResult = 1;

        int maxHeight = heights[fromLeft];
        for (; fromLeft < N; fromLeft++) {
            if (heights[fromLeft] > maxHeight) {
                maxHeight = heights[fromLeft];
                fromLeftResult++;
            }
        }

        maxHeight = heights[fromRight];
        for (fromRight = fromRight - 1; fromRight >= 0; fromRight--) {
            if (heights[fromRight] > maxHeight) {
                maxHeight = heights[fromRight];
                fromRightResult++;
            }
        }

        System.out.printf("%d %d%n", fromLeftResult, fromRightResult);
    }
}
