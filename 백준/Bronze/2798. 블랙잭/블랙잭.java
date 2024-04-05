import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int result = search(arr, N, M);
        System.out.println(result);
    }

    public static int search(int[] arr, int N, int M) {
        int result = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 1; j < N - 1; j++) {
                for (int k = 2; k < N; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if(arr[i] == arr[j] || arr[i] == arr[k] || arr[j] == arr[k]){
                        continue;
                    }
                    if (temp == M) {
                        result = temp;
                     }
                    if (result < temp && temp < M) {
                        result = temp;
                     }
                }
            }
        }
        return result;
    }
}
