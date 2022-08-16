// BOJ - 19941
// Problem Sheet - https://www.acmicpc.net/problem/19941

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 주어지는 문자열의 길이
        int k = Integer.parseInt(st.nextToken()); // 가용한 반경
        String[] list = bf.readLine().split(""); // 입력 문자열을 Array로 분할하여 담음
        int answer = 0; // 햄버거를 먹을 수 있는 최대 사람의 수

        for(int i=0 ; i<n ; i++) {
            if(list[i].equals("H")) {
                int lIdx = -1, rIdx = -1; // 좌우 기준으로 버거가 위치한 인덱스
                for(int j=1 ; j<=k ; j++) {
                    if(i-j >= 0 && list[i-j].equals("P"))
                        lIdx = i-j;
                    if(i+j < n && list[i+j].equals("P") && rIdx == -1)
                        rIdx = i+j;
                }
                if(lIdx != -1) {
                    list[lIdx] = "X";
                    answer++;
                }
                else if(rIdx != -1) {
                    list[rIdx] = "X";
                    answer++;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}