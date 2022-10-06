// BOJ - 13458
// Problem Sheet - https://www.acmicpc.net/problem/13458

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] students = new long[n]; // 각 응시자별 응시자의 수

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            students[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int b = Integer.parseInt(st.nextToken()); // 1명의 총 감독관이 담당 가능한 학생 수
        int c = Integer.parseInt(st.nextToken()); // 1명의 부 감독관이 담당 가능한 학생 수
        long answer = 0; // 필요한 감독관 수의 최솟값

        for(int i=0 ; i<n ; i++) {
            if(students[i] > b)
                answer += 1 + (students[i]-b)/c + (((students[i]-b)%c>0) ? 1 : 0);
            else
                answer++;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}