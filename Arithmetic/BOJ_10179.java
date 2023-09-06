// BOJ - 10179
// Problem Sheet - https://www.acmicpc.net/problem/10179

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            String price = String.format("%.2f", Double.parseDouble(bf.readLine()) * 0.8);
            sb.append("$").append(price).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}