// BOJ - 2751
// Problem Sheet - https://www.acmicpc.net/problem/2751

import java.io.*;

public class Main {

    private static final int BASE_SIZE = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[BASE_SIZE * 2 + 1];
        int N = Integer.parseInt(br.readLine());
        for (int i=0 ; i<N ; i++) {
            arr[Integer.parseInt(br.readLine()) + BASE_SIZE] = true;
        }

        for (int i=0 ; i<=BASE_SIZE*2 ; i++) {
            if (arr[i]) sb.append(i - BASE_SIZE).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}