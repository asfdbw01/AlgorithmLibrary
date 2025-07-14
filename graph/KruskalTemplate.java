/*
 * 📄 KruskalTemplate.java
 *
 * 최소 신장 트리 (MST: Minimum Spanning Tree) - 크루스칼 알고리즘
 *
 * ✔ 그래프의 모든 정점을 최소 비용으로 연결하는 방법을 찾는다.
 * ✔ 간선을 가중치(비용) 오름차순으로 정렬한 뒤, 사이클이 생기지 않도록 선택한다.
 * ✔ Union-Find(Disjoint Set)를 사용해 사이클을 방지한다.
 *
 * 시간복잡도: O(E log E) — 간선 정렬 비용
 *
 * 사용 예:
 * - 네트워크 연결 비용 최소화
 * - 도로/케이블 등 인프라 설치 비용 계산
 *
 * 입력: 노드 개수 n, 간선 정보 int[][] costs = { {from, to, cost}, ... }
 * 출력: MST의 총 비용 (int)
 */


import java.util.*;

public class KruskalTemplate {

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) {
        int n = 4;  // 노드 수
        int[][] costs = {
            {0, 1, 1},
            {0, 2, 2},
            {1, 2, 5},
            {1, 3, 1},
            {2, 3, 8}
        };

        System.out.println(kruskal(n, costs));  // 최소 비용 출력
    }

    public static int kruskal(int n, int[][] costs) {
        List<Edge> edges = new ArrayList<>();
        for (int[] c : costs) {
            edges.add(new Edge(c[0], c[1], c[2]));
        }
        Collections.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int totalCost = 0, count = 0;

        for (Edge e : edges) {
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                totalCost += e.cost;
                count++;
                if (count == n - 1) break;
            }
        }

        return totalCost;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);  // 경로 압축
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) parent[py] = px;
    }
}
