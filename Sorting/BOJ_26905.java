// BOJ - 26905
// Problem Sheet - https://www.acmicpc.net/problem/26905

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int totalSwapCount = 0;
        int swapCount = 0;
        do {
            swapCount = 0;
            for (int i=1 ; i<N ; i++) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                    swapCount++;
                }
            }
            totalSwapCount += swapCount;
        } while (swapCount > 0);

        System.out.println(totalSwapCount);
        br.close();
    }
}
