// BOJ - 28431
// Problem Sheet - https://www.acmicpc.net/problem/28431

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] isPair = new int[10];
        for (int i=0 ; i<5 ; i++) {
            int s = Integer.parseInt(br.readLine());
            isPair[s]++;
        }
        for (int i=0 ; i<10 ; i++) {
            if (isPair[i] % 2 == 1) {
                System.out.println(i);
                break;
            }
        }
        br.close();
    }
}
