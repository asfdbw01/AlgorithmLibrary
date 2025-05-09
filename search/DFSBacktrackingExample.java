package search;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS + 백트래킹 기본 예제
 * n개의 숫자 중에서 m개를 순서 없이 고르는 조합(combination)을 구하는 예시
 */
public class DFSBacktrackingExample {

    public static List<List<Integer>> combinations = new ArrayList<>();

    /**
     * 백트래킹으로 조합 구하기
     * @param start 시작 숫자
     * @param n 전체 숫자 개수
     * @param m 고를 개수
     * @param current 현재까지의 조합 리스트
     */
    public static void dfs(int start, int n, int m, List<Integer> current) {
        if (current.size() == m) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i); // 선택
            dfs(i + 1, n, m, current); // 다음 숫자로 진행
            current.remove(current.size() - 1); // 백트래킹
        }
    }

    public static void main(String[] args) {
        int n = 4; // 1부터 4까지
        int m = 2; // 그 중 2개 고르기

        dfs(1, n, m, new ArrayList<>());

        System.out.println("조합 결과:");
        for (List<Integer> comb : combinations) {
            System.out.println(comb);
        }
    }
}

