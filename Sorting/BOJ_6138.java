// BOJ - 6138
// Problem Sheet - https://www.acmicpc.net/problem/6138

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        Integer[] landmarks = new Integer[N];
        for (int i=0 ; i<N ; i++) {
            landmarks[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(landmarks, Comparator.comparingInt(Math::abs));

        int answer = 0;
        int curLocation = 0;
        for (int i=0 ; i<N ; i++) {
            T -= Math.abs(curLocation - landmarks[i]);
            if (T < 0) break;
            curLocation = landmarks[i];
            answer++;
        }

        System.out.println(answer);
        br.close();
    }
}