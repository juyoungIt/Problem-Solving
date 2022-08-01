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
        int presetValue = 0;
        int answer = 0;

        // 등록된 주파수를 크기 순으로 내림차순 정렬
        Arrays.sort(preset);

        // 세부 로직이 들어가야하는 부분

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}