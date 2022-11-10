// BOJ - 10039
// Problem Sheet - https://www.acmicpc.net/problem/10039

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for(int i=0 ; i<5 ; i++) {
            int score = Integer.parseInt(bf.readLine());
            sum += Math.max(score, 40);
        }

        System.out.println(sum/5);

        bf.close();
        System.exit(0);
    }
}