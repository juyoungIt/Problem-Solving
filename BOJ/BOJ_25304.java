// BOJ - 25304
// Problem Sheet - https://www.acmicpc.net/problem/25304

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int total = Integer.parseInt(bf.readLine()); // 영수증에 찍힌 금액
        int n = Integer.parseInt(bf.readLine()); // 구매한 물건 종류의 수
        int sum = 0; // 실제 구매한 항목의 총 가격

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            sum += (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
        }

        if(sum == total)
            System.out.println("Yes");
        else
            System.out.println("No");

        bf.close();
        System.exit(0);
    }
}