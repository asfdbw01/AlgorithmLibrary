package sort;

import java.util.Arrays;

public class QuickSortExample {

    /**
     * 배열을 퀵정렬로 정렬하는 메서드
     * @param arr 정렬할 배열
     * @param left 시작 인덱스
     * @param right 끝 인덱스
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = arr[(left + right) / 2];
        int l = left;
        int r = right;

        while (l <= r) {
            while (arr[l] < pivot) l++;
            while (arr[r] > pivot) r--;
            if (l <= r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        quickSort(arr, left, r);
        quickSort(arr, l, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
