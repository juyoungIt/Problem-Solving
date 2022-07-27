// BOJ - 14720
// Problem Sheet - https://www.acmicpc.net/problem/14720

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int milk = 0; // 우유의 종류 (0: 딸기, 1: 초코, 2: 바나나)
        int answer = 0;
        for(int i=0 ; i<n ; i++) {
            if(milk == Integer.parseInt(st.nextToken())) {
                milk++;
                milk %= 3; // 우유의 상태를 업데이트
                answer++;
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}
