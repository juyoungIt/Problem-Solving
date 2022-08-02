// BOJ - 3135
// Problem Sheet - https://www.acmicpc.net/problem/3135

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken()); // 시작 주파수
        int b = Integer.parseInt(st.nextToken()); // 목표 주파수
        int n = Integer.parseInt(bf.readLine());  // 즐겨찾기에 등록된 주파수의 수
        int[] preset = new int[n]; // 주파수 즐겨찾기
        for(int i=0 ; i<n ; i++)
            preset[i] = Integer.parseInt(bf.readLine());
        int presetValue = a;
        int answer = 0;

        // B와 가장 가까운 preset을 찾음
        for(int i=0 ; i<n ; i++)
            if(Math.abs(b-preset[i]) < Math.abs(b-presetValue))
                presetValue = preset[i];

        if(Math.abs(a-b) > Math.abs(presetValue-b))
            answer = Math.abs(presetValue-b) + 1;
        else
            answer = Math.abs(a-b);

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}