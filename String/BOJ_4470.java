// BOJ - 4470
// Problem Sheet - https://www.acmicpc.net/problem/4470

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfSentences = Integer.parseInt(bf.readLine());
        for(int i=1 ; i<=numberOfSentences ; i++) {
            sb.append(i)
                    .append(". ")
                    .append(bf.readLine())
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}