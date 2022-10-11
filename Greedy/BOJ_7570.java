// BOJ - 7570
// Problem Sheet - https://www.acmicpc.net/problem/7570

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 어린이의 수
        int[] childrens = new int[n+1]; // 어린이 초기순서
        int[] indexs = new int[n+1];  // 각 번호별 어린이의 위치
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1 ; i<=n ; i++) {
            childrens[i] = Integer.parseInt(st.nextToken());
            indexs[childrens[i]] = i;
        }

        int count = 1;
        int maxCount = 0;
        for(int i=0 ; i<n-1 ; i++) {
            if(indexs[i] < indexs[i+1]) count++;
            else count = 1;
            if(maxCount < count)
                maxCount = count;
        }

        System.out.println(n - maxCount);

        bf.close();
        System.exit(0);
    }
}