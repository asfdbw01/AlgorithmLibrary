package search;

public class UnionFindExample {

    static int[] parent;

    /**
     * 처음 초기화: 자기 자신이 부모
     * @param n 노드 개수
     */
    public static void init(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * Find: 루트 노드를 찾는다 (경로 압축 최적화 적용)
     * @param x 찾을 노드
     * @return 루트 노드
     */
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    /**
     * Union: 두 집합을 합친다
     * @param a 노드 a
     * @param b 노드 b
     */
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA; // 작은 쪽을 부모로 삼아도 되고, 반대로 해도 됨
        }
    }

    /**
     * 두 노드가 같은 집합에 속해있는지 확인
     * @param a 노드 a
     * @param b 노드 b
     * @return true (같은 집합), false (다른 집합)
     */
    public static boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int n = 6; // 노드 수
        init(n);

        union(0, 1);
        union(2, 3);
        union(1, 2);

        System.out.println("0과 3은 같은 집합인가? " + isConnected(0, 3)); // true
        System.out.println("0과 5는 같은 집합인가? " + isConnected(0, 5)); // false
    }
}
