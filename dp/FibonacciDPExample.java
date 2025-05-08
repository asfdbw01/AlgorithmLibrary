package dp;

import java.util.Arrays;

public class FibonacciDPExample {

    static int[] memo;

    /**
     * 피보나치 수열을 DP로 푸는 기본형
     * @param n 몇 번째 수를 구할지
     * @return n번째 피보나치 수
     */
    public static int fibonacci(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1); // 초기화: 아직 계산 안한 값은 -1
        return fib(n);
    }

    private static int fib(int n) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];
        return memo[n] = fib(n - 1) + fib(n - 2);
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int n = 10;
        System.out.println(n + "번째 피보나치 수: " + fibonacci(n)); // 55
    }
}
