// BOJ - 15969
// Problem Sheet - https://www.acmicpc.net/problem/15969

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int min = 1000;
        int max = 0;
        for(int i=0 ; i<N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(min > num) {
                min = num;
            }
            if(max < num) {
                max = num;
            }
        }

        System.out.println(max - min);

        bf.close();
        System.exit(0);
    }
}