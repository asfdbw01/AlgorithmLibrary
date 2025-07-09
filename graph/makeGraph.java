//Integer 그래프 만들기 메서드

public static List<List<Integer>> makeGraph( int[][] vertex) {
        int n = 0;
        for (int[] edge : vertex) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : vertex) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
