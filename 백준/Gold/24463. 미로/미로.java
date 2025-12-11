import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] maze;

    public static void main(String[] args) throws IOException {
        // 경로 복원 집중
        // + : -1 벽
        // . : 0 길
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                String s = line.substring(j, j + 1);
                if (s.equals(".")) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = -1;
                }
            }
        }

        // 여기까지가 입력 끝
        // 시작과 끝 찾기
        // i 가 0, N - 1
        // j 가 0, M - 1
        ArrayList<int[]> points = new ArrayList<>();

        for (int i : new int[] {0, N - 1} ) {
            for (int j = 0; j < M; j ++) {
                if (maze[i][j] == 0) {
                    points.add(new int[] {i, j});
                }
            }
        }

        for (int j : new int[] {0, M - 1} ) {
            for (int i = 0; i < N; i ++) {
                if (maze[i][j] == 0) {
                    points.add(new int[] {i, j});
                }
            }
        }

//        System.out.println(points.size());
        // 노드 사용 풀이
        ArrayList<int[]> path = BFSWithNode(points.get(0), points.get(1));

        String[][] mazeToString = new String[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == -1) {
                    mazeToString[i][j] = "+";
                } else {
                    mazeToString[i][j] = "@";
                }
            }
        }

        for (int[] p : path) {
            mazeToString[p[0]][p[1]] = ".";
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(mazeToString[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());


        // 부모 배열 사용 풀이

    }


    static class Node {
        int x;
        int y;
        Node parent;

        Node(int x, int y, Node parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
    }

    static ArrayList<int[]> BFSWithNode(int[] start, int[] end) {

        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Node(start[0], start[1], null));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 도착 지점이면 경로 복원 후 즉시 반환
            if (cur.x == end[0] && cur.y == end[1]) {
                return buildPath(cur);
            }

            for (int[] d : dirs) {
                int nx = cur.x + d[0];
                int ny = cur.y + d[1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (maze[nx][ny] == -1 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, cur));
            }
        }

        return new ArrayList<>(); // 안전 처리
    }

    static ArrayList<int[]> buildPath(Node endNode) {
        ArrayList<int[]> path = new ArrayList<>();
        Node cur = endNode;
        while (cur != null) {
            path.add(new int[]{cur.x, cur.y});
            cur = cur.parent;
        }
        Collections.reverse(path);
        return path;
    }






    // 부모 배열 사용
    static void BFS(int[] start, int[] end) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();


    }
}
