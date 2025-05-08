package two_pointer;

import java.util.Arrays;

public class SlidingWindowExample {

    /**
     * 고정된 크기의 윈도우로 배열의 최대합을 구하는 슬라이딩 윈도우 기본형
     * @param arr 배열
     * @param k 윈도우 크기
     * @return 최대 구간합
     */
    public static int slidingWindow(int[] arr, int k) {
        int n = arr.length;
        int windowSum = 0;
        int maxSum = 0;

        // 초기 윈도우 합 계산
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // 슬라이딩 윈도우 이동
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(Arrays.toString(arr));
        int result = slidingWindow(arr, k); // 5+1+3 = 9
        System.out.println("최대 구간합 (길이 " + k + "): " + result);
    }
}
