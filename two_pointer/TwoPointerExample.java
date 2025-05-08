package two_pointer;

import java.util.Arrays;

public class TwoPointerExample {

    /**
     * 정렬된 배열에서 두 수의 합이 target이 되는지 찾는 기본형
     * @param arr 정렬된 배열
     * @param target 목표 합
     * @return 존재하면 true, 없으면 false
     */
    public static boolean twoPointer(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println("합이 " + target + "이 되는 두 수: " + arr[left] + ", " + arr[right]);
                return true;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    // 간단한 사용 예시
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 11, 15};

        System.out.println(Arrays.toString(arr));
        boolean found = twoPointer(arr, 9); // 4 + 5 = 9
        System.out.println("찾았나? " + found);
    }
}
