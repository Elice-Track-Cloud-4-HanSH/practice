package d02;

import java.util.ArrayList;

public class ArrayCalculation {
    public static void main(String[] args) {
        singleArray();
        twoDArray();
    }

    public static void singleArray() {
        // 지시사항 1. 크기 10의 배열 arr를 선언합니다.
        int[] arr = new int[10];
        // 지시사항 2. for 반복문을 사용하여 1부터 10까지의 수를 arr 배열에 순서대로 넣습니다.
        for (int i = 0; i < 10; i++) {
            arr[i] = i+1;
        }
        // 배열 요소 출력
        for (int i = 0; i < 10; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 지시사항 3. 지시사항에 맞게 데이터를 변경합니다.
        // 배열 내부, 인덱스 3의 값을 10으로 변경
        arr[3] = 10;
        // 배열 내부, 9번째 위치의 값을 7로 변경
        arr[8] = 7;
        // 변경 후, 배열 요소 출력
        for (int i = 0; i < 10; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void twoDArray() {
        int row = 3;
        int col = 5;
        // 지시사항 1. 크기 3 X 5의 배열 arr를 선언합니다.
        int[][] arr = new int[row][5];
        // 지시사항 2. 2중 for 문법을 사용하여 arr 배열에 1부터 15까지의 수를 순서대로 넣습니다.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = i*5 + j + 1;
            }
        }

        // 배열 요소 출력
        print2D(arr, row, col);

        // 지시사항 3. 지시사항에 맞게 데이터를 변경합니다.
        // arr 배열의 2행 3열의 데이터를 10으로 변경합니다.
        arr[1][2] = 10;
        // arr 배열의 1행 1열의 데이터를 7로 변경합니다.
        arr[0][0] = 7;

        // 변경 후, 배열 요소 출력
        print2D(arr, row, col);
    }

    public static void print2D(int[][] arr, int row, int col) {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < 5; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void arrayList() {
        // 지시사항 1. 동적 배열 arr를 선언합니다.
        ArrayList<Integer> arr = new ArrayList<>();
        // 지시사항 2. for 반복문을 사용하여 arr 배열에 1부터 10까지의 수를 순서대로 넣습니다.
        for (int i = 0; i < 10; i++) {
            arr.add(i+1);
        }

        // 배열 요소 출력
        printArrayList(arr);

        // 지시사항 3. arr 배열의 길이를 출력합니다.
        System.out.println("배열의 길이: " + arr.size());

        // 지시사항 4. 지시사항에 맞게 데이터를 삭제합니다.
        // 배열의 맨 뒤 요소 삭제
        // elice 실습 환경에서는 removeLast가 없다...
        arr.remove(arr.size()-1);
        // 배열의 2번째 요소 삭제
        arr.remove(1);

        // 삭제 후, 배열 요소 출력
        printArrayList(arr);

        // 지시사항 5. 지시사항에 맞게 데이터를 추가합니다.
        // 배열의 맨 뒤에 데이터 추가
        arr.add(21);
        // 배열의 3번째 위치에 데이터 삽입
        arr.add(2, 30);

        // 추가 후, 배열 요소 출력
        printArrayList(arr);
    }

    public static void printArrayList(ArrayList<?> arr) {
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
