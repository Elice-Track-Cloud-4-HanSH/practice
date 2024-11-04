package chaptertest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N명의 사람이 화살표 게임을 한다.
 * 화살표 게임이란, 아래와 같은 규칙으로 한 사람을 선택하여, 선택된 사람은 벌칙을 받게 되는 게임이다.
 *
 * 1. N명의 사람 중 한 사람을 술래로 정한다.
 * 2. N명의 사람이 왼손과 오른손으로 각각 한 사람씩 지목한다. 두 손으로 같은 사람을 지목할 수는 없다.
 * 3. 술래는 특정 숫자를 외친다. 이 숫자를 t라고 하자.
 * 술래부터 시작해서 왼손 혹은 오른손 중 한 손을 선택한다.
 * 예를 들어, 왼손을 선택할 경우 왼손으로 지목하고 있는 사람이 술래가 되고, 오른손을 선택할 경우 오른손으로 지목하고 있는 사람이 술래가 된다.
 * 4. 다시 3.의 과정으로 가서 이 과정을 t번 반복한다.
 * 즉, 술래가 t번 바뀌게 되고, t번째에 술래로 선택되는 사람이 벌칙을 받게 된다.
 *
 * N명이 왼손과 오른손으로 어떤 사람을 가리켰는지와 맨 처음 술래의 번호가 주어졌을 때,
 * 가능한 모든 t에 대해서 술래로 단 한번도 지목을 받을 수 없는 사람의 수를 구하여라.
 */

// 한마디로 처음 술래가 K인데, 무슨 수를 써서라도 도달할 수 없는 사람의 수를 구하는 내용

/*
입력
6 1
3 5
1 3
2 5
1 3
1 2
1 5

출력
2
 */

public class Q3PointingGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputtedArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputtedArr[0]); // 사람 수
        int K = Integer.parseInt(inputtedArr[1]); // 술래 번호

        boolean[] visited = new boolean[N+1];
        visited[0] = true;
        Node[] nodes = new Node[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        int a, b;
        for (int i = 1; i <= N; i++) {
            inputtedArr = br.readLine().split(" ");
            a = Integer.parseInt(inputtedArr[0]);
            b = Integer.parseInt(inputtedArr[1]);

            nodes[i].addChild(nodes[a]);
            nodes[i].addChild(nodes[b]);
        }

        Queue<Node> q = new LinkedList<>();

        visited[K] = true;
        q.add(nodes[K]);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node child : cur.children) {
                if (!visited[child.val]) {
                    visited[child.val] = true;
                    q.add(child);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result += !visited[i] ? 1 : 0;
        }

        System.out.println(result);
    }

    static class Node {
        int val;
        List<Node> children = new ArrayList<>();
        Node(int val) {
            this.val = val;
        }
        void addChild(Node child) {
            children.add(child);
        }
    }
}
