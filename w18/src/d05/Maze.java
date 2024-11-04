package d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    static boolean[][] visited;
    static int[][] maze;

    static Queue<Position> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        String[] inputted = br.readLine().split(" ");

        N = Integer.parseInt(inputted[0]);
        M = Integer.parseInt(inputted[1]);

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            inputted = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(inputted[j]);
            }
        }

        queue.add(new Position(0, 0, 0));
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            visited[pos.x][pos.y] = true;
            if (pos.check()) {
                System.out.println(pos.cost);
                return;
            }

            if (canMove(pos.x-1, pos.y)) {
                visited[pos.x-1][pos.y] = true;
                queue.add(new Position(pos.x-1, pos.y, pos.cost+1));
            }
            if (canMove(pos.x, pos.y-1)) {
                visited[pos.x][pos.y-1] = true;
                queue.add(new Position(pos.x, pos.y-1, pos.cost+1));
            }
            if (canMove(pos.x+1, pos.y)) {
                visited[pos.x+1][pos.y] = true;
                queue.add(new Position(pos.x+1, pos.y, pos.cost+1));
            }
            if (canMove(pos.x, pos.y+1)) {
                visited[pos.x][pos.y+1] = true;
                queue.add(new Position(pos.x, pos.y+1, pos.cost+1));
            }
        }
        System.out.println(-1);
    }

    public static boolean canMove(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && (!visited[x][y]) && (maze[x][y] == 1);
    }

    static class Position {
        int x, y;
        int cost;

        Position(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public boolean check() {
            return x == N-1 && y == M-1;
        }
    }
}
