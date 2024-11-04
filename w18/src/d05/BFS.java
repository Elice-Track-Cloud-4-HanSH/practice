package d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[] visited;
    static Queue<Node> queue = new LinkedList<>();
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        String[] inputted = br.readLine().split(" ");
        N = Integer.parseInt(inputted[0]);
        M = Integer.parseInt(inputted[1]);

        visited = new boolean[N + 1];
        nodes = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            inputted = br.readLine().split(" ");
            int a = Integer.parseInt(inputted[0]);
            int b = Integer.parseInt(inputted[1]);
            nodes[a].addNext(nodes[b]);
            nodes[b].addNext(nodes[a]);
        }

        for (int i = 1; i <= N; i++) {
            nodes[i].nexts.sort((Node a, Node b) -> a.curr - b.curr);
        }

        queue.add(nodes[1]);
        visited[1] = true;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.curr);
            for(Node next: curr.nexts) {
                if (!visited[next.curr]) {
                    queue.add(next);
                    visited[next.curr] = true;
                }
            }
        }
    }
}

class Node {
    int curr;
    List<Node> nexts;

    public Node(int curr) {
        this.curr = curr;
        nexts = new LinkedList<>();
    }

    public void addNext(Node next) {
        nexts.add(next);
    }
}