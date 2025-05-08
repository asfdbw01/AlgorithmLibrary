package search;

import java.util.*;

public class BFSExample {

    // 4방향 이동 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    /**
     * 2차원 배열 기준 BFS 탐색 기본형
     * @param startX 시작 X좌표
     * @param startY 시작 Y좌표
     * @param map    2차원 맵 (0: 통로, -1: 벽)
     */
    public static void bfs(int startX, int startY, int[][] map) {
        int n = map.length;
        int m = map[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            System.out.println("현재 방문: (" + x + ", " + y + ")");

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                // 벽 체크
                if (map[nx][ny] == -1) continue;
                // 방문 체크
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int[][] map = {
            {0, 0, 0, -1, 0},
            {0, -1, 0, -1, 0},
            {0, -1, 0, 0, 0},
            {0, 0, 0, -1, 0},
            {-1, -1, 0, 0, 0}
        };
        bfs(0, 0, map);
    }
}
