// BOJ - 1448
// Problem Sheet - https://www.acmicpc.net/problem/1448

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Integer[] straws = new Integer[n]; // 빨대의 길이
        for(int i=0 ; i<n ; i++)
            straws[i] = Integer.parseInt(bf.readLine());
        int answer = -1;

        Arrays.sort(straws, Collections.reverseOrder());
        for(int i=0 ; i<n-2 ; i++) {
            if(straws[i] < straws[i+1] + straws[i+2]) {
                answer = straws[i] + straws[i+1] + straws[i+2];
                break;
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}