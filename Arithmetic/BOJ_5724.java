// BOJ - 5724
// Problem Sheet - https://www.acmicpc.net/problem/5724

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(bf.readLine());
            if(n == 0) break;
            sb.append(calcuate(n)).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int calcuate(int n) {
        int sum = 0;
        for(int i=1 ; i<=n ; i++) {
            sum += i * i;
        }
        return sum;
    }
}