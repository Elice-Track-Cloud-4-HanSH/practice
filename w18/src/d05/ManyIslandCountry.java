package d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ManyIslandCountry {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[] visited;
    static Node[] nodes;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();
        bfs();
    }

    static void init() throws IOException {
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
    }

    static int bfs() {
        Arrays.fill(visited, false);
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                result++;
                visited[i] = true;
                queue.add(nodes[i]);

                while (!queue.isEmpty()) {
                    Node curr = queue.poll();
                    for (Node next : curr.nexts) {
                        if (!visited[next.curr]) {
                            visited[next.curr] = true;
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return result;
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
    }
}
