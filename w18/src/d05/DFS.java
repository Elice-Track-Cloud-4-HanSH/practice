package d05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    static Node[] nodes;
    static boolean[] visited;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        nodes = new Node[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            nodes[a].addNext(nodes[b]);
        }

        dfs(nodes[1]);
    }

    public static void dfs(Node curr) {
        if (!visited[curr.curr]) {
            System.out.printf("%d ", curr.curr);
            visited[curr.curr] = true;
            while (!curr.nexts.isEmpty()) {
                Node next = curr.nexts.remove(0);
                dfs(next);
            }
        }
    }
}