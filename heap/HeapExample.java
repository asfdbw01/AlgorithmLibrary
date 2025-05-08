package heap;

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;

/**
 * 최소 힙과 최대 힙 기본 사용법 예제
 */
public class HeapExample {

    /**
     * 주어진 배열로 최소 힙을 구성하고 오름차순으로 값을 출력
     * @param arr 정수 배열
     */
    public static void minHeapExample(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
        }

        System.out.print("Min Heap (오름차순): ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
    }

    /**
     * 주어진 배열로 최대 힙을 구성하고 내림차순으로 값을 출력
     * @param arr 정수 배열
     */
    public static void maxHeapExample(int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            maxHeap.offer(num);
        }

        System.out.print("Max Heap (내림차순): ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int[] arr = {5, 1, 10, 3, 7};

        System.out.println("원본 배열: " + Arrays.toString(arr));
        minHeapExample(arr); // 1 3 5 7 10
        maxHeapExample(arr); // 10 7 5 3 1
    }
}

