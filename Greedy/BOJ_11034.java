// BOJ - 11034
// Problem Sheet - https://www.acmicpc.net/problem/11034

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String tmp; // 입력된 String을 일시저장
        int[] index = new int[3]; // 각 캥거루의 위치를 저장
        int diff1, diff2;

        while((tmp = bf.readLine()) != null) {
            st = new StringTokenizer(tmp);
            for(int i=0 ; i<3 ; i++)
                index[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(index); // 좌표를 크기순으로 정렬
            diff1 = Math.abs(index[0] - index[1]);
            diff2 = Math.abs(index[1] - index[2]);
            System.out.println(Math.max(diff1, diff2) -1);
        }

        bf.close();
        System.exit(0);
    }
}