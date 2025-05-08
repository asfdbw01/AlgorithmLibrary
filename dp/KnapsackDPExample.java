package dp;

public class KnapsackDPExample {

    /**
     * 0-1 Knapsack 문제 기본형
     * @param weights 각 물건의 무게 배열
     * @param values 각 물건의 가치 배열
     * @param capacity 배낭 최대 무게
     * @return 배낭에 담을 수 있는 최대 가치
     */
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // i: 아이템 번호, w: 현재 가능한 무게
        for (int i = 1; i < n + 1; i++) {
            for (int w = 0; w < capacity + 1; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i - 1][w],                      // 현재 물건 안 넣는 경우
                        dp[i - 1][w - weights[i - 1]] + values[i - 1] // 현재 물건 넣는 경우
                    );
                } else {
                    dp[i][w] = dp[i - 1][w]; // 물건 무게 초과, 못 넣음
                }
            }
        }

        return dp[n][capacity];
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int[] weights = {2, 1, 3, 2};
        int[] values = {12, 10, 20, 15};
        int capacity = 5;

        int result = knapsack(weights, values, capacity);
        System.out.println("최대 가치: " + result); // 최대 37
    }
}
