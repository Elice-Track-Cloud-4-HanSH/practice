package d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumOfComponents {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static Node[] nodes;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        String [] inputted = br.readLine().split(" ");

        int N = Integer.parseInt(inputted[0]);
        int M = Integer.parseInt(inputted[1]);

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

            nodes[a].addNode(nodes[b]);
            nodes[b].addNode(nodes[a]);
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            result++;


            queue.add(nodes[i]);
            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                visited[curr.curr] = true;

                for (Node next: curr.nexts) {
                    if (!visited[next.curr]) {
                        visited[next.curr] = true;
                        queue.add(next);
                    }
                }
            }
        }
        System.out.println(result);
    }

    static class Node {
        int curr;
        Set<Node> nexts = new HashSet<>();

        public Node(int curr) {
            this.curr = curr;
        }

        public void addNode(Node node) {
            nexts.add(node);
        }
    }
}
