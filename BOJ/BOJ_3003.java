// BOJ - 3003
// Problem Sheet - https://www.acmicpc.net/problem/3003

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] std = {1, 1, 2, 2, 2, 8};
        int[] answer = new int[6];

        for(int i=0 ; i<6 ; i++)
            answer[i] = std[i] - Integer.parseInt(st.nextToken());

        for(int i=0 ; i<6 ; i++)
            System.out.print(answer[i] + " ");
        System.out.println();

        bf.close();
        System.exit(0);
    }
}