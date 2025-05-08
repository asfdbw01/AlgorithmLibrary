package search;

import java.util.*;

public class DFSExample {

    // 4방향 이동 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] visited;

    /**
     * 2차원 배열 기준 DFS 탐색 기본형
     * @param x 시작 x좌표
     * @param y 시작 y좌표
     * @param map 2차원 맵 (0: 통로, -1: 벽)
     */
    public static void dfs(int x, int y, int[][] map) {
        int n = map.length;
        int m = map[0].length;

        visited[x][y] = true;
        System.out.println("현재 방문: (" + x + ", " + y + ")");

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위 밖이면 패스
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            // 벽이면 패스
            if (map[nx][ny] == -1) continue;
            // 이미 방문했으면 패스
            if (visited[nx][ny]) continue;

            dfs(nx, ny, map);
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

        visited = new boolean[map.length][map[0].length];
        dfs(0, 0, map);
    }
}
