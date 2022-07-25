// BOJ - 2437
// Problem Sheet - https://www.acmicpc.net/problem/2437

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] blocks = new int[n]; // 추들의 무게를 저장
        for(int i=0 ; i<n ; i++)
            blocks[i] = Integer.parseInt(st.nextToken());
        int sum = 0;

        Arrays.sort(blocks); // 무게추의 무게순으로 오름차순 정렬

        for(int i=0 ; i<n ; i++) {
            if(sum+1 < blocks[i])
                break;
            sum += blocks[i];
        }

        System.out.println(sum+1);

        bf.close();
        System.exit(0);
    }
}