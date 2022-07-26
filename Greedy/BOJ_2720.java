// BOJ - 2720
// Problem Sheet - https://www.acmicpc.net/problem/2720

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        Scanner key = new Scanner(System.in);
        
        int[] unit = {25, 10, 5, 1};
        int[] answer = new int[4];
        int remain;
        
        int tSize = key.nextInt();
        int[] tCase = new int[tSize];
        for(int i=0 ; i<tSize ; i++)
            tCase[i] = key.nextInt();
        
        for(int i=0 ; i<tSize ; i++) {
            remain = tCase[i];
            for(int j=0 ; j<3 ; j++) {
                answer[j] = remain / unit[j];
                remain %= unit[j];
            }
            answer[3] = remain;
            for(int count : answer)
                System.out.print(count + " ");
            System.out.println();
            for(int j=0 ; j<4 ; j++)
                answer[j] = 0;
        }

        key.close();
        System.exit(0);
    }
}