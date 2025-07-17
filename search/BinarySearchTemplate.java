//이분탐색

import java.util.*;

public class BinarySearchTemplate {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};

        // 값이 존재하는지 찾기
        int target = 7;
        int idx = binarySearch(arr, target);
        System.out.println("Index of " + target + ": " + idx);

        // 조건을 만족하는 최소값 찾기
        int answer = lowerBound(1, 100, x -> x * x >= 50);
        System.out.println("최소 x: " + answer + ", x*x = " + (answer * answer));
    }

    /**
     * 배열에서 target의 인덱스를 반환 (없으면 -1)
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    /**
     * 범위 [left, right]에서 조건을 만족하는 가장 작은 값 반환
     * 만족하는 값이 없으면 right+1 반환
     */
    public static int lowerBound(int left, int right, Predicate<Integer> condition) {
        int ans = right + 1;

        while (left <= right) {
            int mid = l
