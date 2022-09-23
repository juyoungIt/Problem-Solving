// BOJ - 2309
// Problem Sheet - https://www.acmicpc.net/problem/2309

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int sum = 0; // 난쟁이 키의 합산값
        int targetA = 0, targetB = 0; // 가짜 난쟁이의 인덱스

        for(int i=0 ; i<9 ; i++) {
            heights[i] = Integer.parseInt(bf.readLine());
            sum += heights[i];
        }
        Arrays.sort(heights); // 난쟁이를 키 별로 오름차순 정렬

        for(int i=0 ; i<9 ; i++) {
            for(int j=i+1 ; j<9 ; j++) {
                if(sum - heights[i] - heights[j] == 100) {
                    targetA = i;
                    targetB = j;
                    break;
                }
            }
        }

        for(int i=0 ; i<9 ; i++)
            if(i != targetA && i != targetB)
                System.out.println(heights[i]);

        bf.close();
        System.exit(0);
    }
}