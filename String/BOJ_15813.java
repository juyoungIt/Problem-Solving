// BOJ - 15813
// Problem Sheet - https://www.acmicpc.net/problem/15813

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;

        int lengthOfName = Integer.parseInt(bf.readLine());
        String name = bf.readLine();
        for(int i=0 ; i<lengthOfName ; i++) {
            score += (name.charAt(i)-'A'+1);
        }

        System.out.println(score);

        bf.close();
        System.exit(0);
    }
}