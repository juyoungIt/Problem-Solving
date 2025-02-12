// BOJ - 2751
// Problem Sheet - https://www.acmicpc.net/problem/2751

import java.io.*;

public class Main {

    private static int N;
    private static int[] arr, tmp;

    public static void main(String[] args) throws IOException {
        input();
        divide(0, N-1);
        System.out.println(printArr());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        tmp = new int[N];
        br.close();
    }

    private static void divide(int start, int end) {
        if (start == end) return ;
        int mid = (start + end) / 2;
        divide(start, mid);
        divide(mid + 1, end);
        combine(start, end);
    }

    private static void combine(int start, int end) {
        int mid = (start + end) / 2;
        int left = start, right = mid + 1;
        int sortedIndex = start;
        while (left <= mid && right <= end) {
            if (arr[left] > arr[right]) {
                tmp[sortedIndex++] = arr[right++];
            } else {
                tmp[sortedIndex++] = arr[left++];
            }
        }
        while (left <= mid) {
            tmp[sortedIndex++] = arr[left++];
        }
        while (right <= end) {
            tmp[sortedIndex++] = arr[right++];
        }
        for (int i=start ; i<=end ; i++) {
            arr[i] = tmp[i];
        }
    }

    private static String printArr() {
        StringBuilder sb = new StringBuilder();
        for (int element : arr) {
            sb.append(element).append("\n");
        }
        return sb.toString();
    }
}
