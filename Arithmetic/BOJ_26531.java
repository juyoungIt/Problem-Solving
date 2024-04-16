// BOJ - 26531
// Problem Sheet - https://www.acmicpc.net/problem/26531

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputTokens = br.readLine().split(" ");

        int operandA = Integer.parseInt(inputTokens[0]);
        int operandB = Integer.parseInt(inputTokens[2]);
        int result = Integer.parseInt(inputTokens[4]);

        if (operandA + operandB == result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        br.close();
        System.exit(0);
    }
}