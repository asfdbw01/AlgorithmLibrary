// 최대공약수 (GCD)를 구하는 유클리드 호제법 템플릿
public class GcdTemplate {
    // a와 b의 최대공약수 반환
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    // 배열 전체의 GCD를 구할 경우
    public static int arrayGcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    // 예시 실행
    public static void main(String[] args) {
        System.out.println(gcd(48, 18)); // 6
        int[] nums = {24, 60, 36};
        System.out.println(arrayGcd(nums)); // 12
    }
}
