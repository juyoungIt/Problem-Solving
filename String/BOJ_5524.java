// BOJ - 5524
// Problem Sheet - https://www.acmicpc.net/problem/5524

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfWords = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfWords ; i++) {
            sb.append(bf.readLine().toLowerCase()).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}