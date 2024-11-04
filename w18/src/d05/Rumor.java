package d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rumor {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    static boolean[] visited;
    static Node[] nodes;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int result = 0;

        String[] inputted = br.readLine().split(" ");
        N = Integer.parseInt(inputted[0]);
        M = Integer.parseInt(inputted[1]);

        visited = new boolean[N + 1];
        nodes = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            inputted = br.readLine().split(" ");
            a = Integer.parseInt(inputted[0]);
            b = Integer.parseInt(inputted[1]);

            nodes[a].addNext(nodes[b]);
            nodes[b].addNext(nodes[a]);
        }

        for (int i = 1; i <= N; i++) {
            nodes[i].sort();
        }

        addQueue(nodes[1]);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node next: curr.nexts) {
                if (!visited[next.curr]) {
                    addQueue(next);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static void addQueue(Node node) {
        visited[node.curr] = true;
        queue.add(node);
    }

    static class Node {
        int curr;
        List<Node> nexts = new ArrayList<>();

        public Node(int curr) {
            this.curr = curr;
        }

        public void addNext(Node next) {
            nexts.add(next);
        }

        public void sort() {
            nexts.sort((n1, n2) -> n1.curr - n2.curr);
        }
    }
}
