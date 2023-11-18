// BOJ - 28701
// Problem Sheet - https://www.acmicpc.net/problem/28701

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int cubeSum = 0;
        for(int i=1 ; i<=n ; i++) {
            sum += i;
            cubeSum += (int)Math.pow(i, 3);
        }
        sb.append(sum).append("\n");
        sb.append((int)Math.pow(sum, 2)).append("\n");
        sb.append(cubeSum).append("\n");

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}