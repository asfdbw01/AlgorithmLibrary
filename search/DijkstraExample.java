package search;

import java.util.*;

/**
 * 가중치가 있는 그래프에서 "최단거리"를 찾는 Dijkstra 기본 템플릿
 */
public class DijkstraExample {

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance; // 거리 짧은 순으로 정렬
        }
    }

    public static int[] dijkstra(List<List<Node>> graph, int start) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.index;
            int curDist = current.distance;

            if (curDist > dist[curNode]) continue; // 이미 최적 경로로 방문한 경우 무시

            for (Node next : graph.get(curNode)) {
                int cost = dist[curNode] + next.distance;
                if (cost < dist[next.index]) {
                    dist[next.index] = cost;
                    pq.add(new Node(next.index, cost));
                }
            }
        }

        return dist;
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int n = 6; // 노드 수
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 예시 그래프 (단방향)
        graph.get(0).add(new Node(1, 2));
        graph.get(0).add(new Node(2, 5));
        graph.get(1).add(new Node(2, 3));
        graph.get(1).add(new Node(3, 6));
        graph.get(2).add(new Node(3, 2));
        graph.get(3).add(new Node(4, 1));
        graph.get(4).add(new Node(5, 2));
        
        //예시 그래프 이거까지 추가하면 양방향
        graph.get(1).add(new Node(0, 2));
        graph.get(2).add(new Node(0, 5));
        graph.get(2).add(new Node(1, 3));
        graph.get(3).add(new Node(1, 6));
        graph.get(3).add(new Node(2, 2));
        graph.get(4).add(new Node(3, 1));
        graph.get(5).add(new Node(4, 2));


        int[] dist = dijkstra(graph, 0); // 0번 노드에서 시작

        for (int i = 0; i < dist.length; i++) {
            System.out.println("0번 노드 -> " + i + "번 노드 최단거리: " + dist[i]);
        }
    }
}
