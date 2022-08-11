// BOJ - 18310
// Problem Sheet - https://www.acmicpc.net/problem/18310

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 집의 수
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] homePos = new int[n]; // 집의 위치를 저장하는 배열
        for(int i=0 ; i<n ; i++)
            homePos[i] = Integer.parseInt(st.nextToken());

        // 집의 위치 값을 인덱스 순으로 오름차순 정렬
        Arrays.sort(homePos);

        // 중간값을 구하여 정답을 출력
        System.out.println(homePos[(n-1)/2]);

        bf.close();
        System.exit(0);
    }
}