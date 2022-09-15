// BOJ - 19539
// Problem Sheet - https://www.acmicpc.net/problem/19539

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 사과 나무의 수
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int sum = 0; // 사과나무 높이의 합
        int diviedTwo = 0; // 2로 나눈 몫의 합
        boolean isAvailable = false;

        for(int i=0 ; i<n ; i++) {
            int height = Integer.parseInt(st.nextToken());
            sum += height;
            diviedTwo += height / 2;
        }

        if(sum%3 != 0)
            isAvailable = false;
        else {
            if(sum/3 <= diviedTwo) isAvailable = true;
            else isAvailable = false;
        }

        System.out.println((isAvailable) ? "YES" : "NO");

        bf.close();
        System.exit(0);
    }
}