// BOJ - 32373
// Problem Sheet - https://www.acmicpc.net/problem/32373

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        boolean isValid = true;
        input = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            int value = Integer.parseInt(input[i]);
            if (value % k != i % k) {
                isValid = false;
                break;
            }
        }

        System.out.println(isValid ? "Yes" : "No");
        br.close();
    }
}