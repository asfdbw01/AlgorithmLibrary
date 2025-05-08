package sort;

import java.util.Arrays;

public class MergeSortExample {

    /**
     * 배열을 병합 정렬로 정렬하는 메서드
     * @param arr 정렬할 배열
     * @param left 시작 인덱스
     * @param right 끝 인덱스
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return; // 원소가 1개면 정렬 완료

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;     // 왼쪽 배열 인덱스
        int j = mid + 1;  // 오른쪽 배열 인덱스
        int k = 0;        // temp 배열 인덱스

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // temp 배열을 arr에 복사
        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
