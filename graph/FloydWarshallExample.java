package graph;

import java.util.Arrays;

public class FloydWarshallExample {

    static final int INF = 1_000_000_000; // 무한대 값 (충분히 큰 값)

    /**
     * 플로이드 워셜 알고리즘 기본형
     * @param graph 인접 행렬 형태로 주어지는 그래프
     * @return 모든 쌍 최단 거리 배열
     */
    public static int[][] floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        // 초기화: 그래프 복사
        for (int i = 0; i < n; i++) {
            dist[i] = Arrays.copyOf(graph[i], n);
        }

        // 플로이드 워셜 알고리즘 핵심
        for (int k = 0; k < n; k++) {         // 경유지
            for (int i = 0; i < n; i++) {      // 출발지
                for (int j = 0; j < n; j++) {  // 도착지
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int INF = FloydWarshallExample.INF;
        int[][] graph = {
            {0, 3, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };

        int[][] result = floydWarshall(graph);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
