// BOJ - 2828
// Problem Sheet - https://www.acmicpc.net/problem/2828

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 스크린의 칸
        int m = Integer.parseInt(st.nextToken()); // 바구니가 차지하는 칸
        int j = Integer.parseInt(bf.readLine());  // 떨어지는 사과의 수
        int answer = 0; // 바구니의 최소 이동거리
        int leftIdx = 1, rightIdx = m;
        int dropPos; // 사과가 떨어지는 위치의 인덱스
        int tmp;

        for(int i=0 ; i<j ; i++) {
            dropPos = Integer.parseInt(bf.readLine());
            if(dropPos >= leftIdx && dropPos <= rightIdx)
                continue;
            tmp = (Math.abs(dropPos-leftIdx) < Math.abs(dropPos-rightIdx)) ? dropPos-leftIdx : dropPos-rightIdx;
            leftIdx += tmp;
            rightIdx += tmp;
            answer += Math.abs(tmp);
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}