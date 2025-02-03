// BOJ - 1182
// Problem Sheet - https://www.acmicpc.net/problem/1182

import java.io.*;

public class Main {

    private static int N, S;
    private static int[] arr;
    private static int sum = 0;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        checkSeqSum(0, 0);
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        S = Integer.parseInt(row[1]);
        arr = new int[N];
        row = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(row[i]);
        }
        br.close();
    }

    private static void checkSeqSum(int depth, int startIndex) {
        if (depth > 0 && sum == S) {
            answer++;
        }
        for (int i=startIndex ; i<N ; i++) {
            sum += arr[i];
            checkSeqSum(depth + 1, i + 1);
            sum -= arr[i];
        }
    }
}