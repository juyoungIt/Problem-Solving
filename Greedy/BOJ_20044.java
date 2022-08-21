// BOJ - 20044
// Problem Sheet - https://www.acmicpc.net/problem/20044

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 팀의 수
        int[] capas = new int[2*n]; // 각 학생의 능력치
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<2*n ; i++)
            capas[i] = Integer.parseInt(st.nextToken());
        int answer;

        Arrays.sort(capas); // 능력치 기준 정렬
        answer = capas[0] + capas[2*n-1];
        for(int i=1 ; i<n ; i++)
            if(answer > capas[i] + capas[2*n-1-i])
                answer = capas[i] + capas[2*n-1-i];

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}