// BOJ - 9237
// Problem Sheet - https://www.acmicpc.net/problem/9237

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 묘목의 수
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Integer[] time = new Integer[n]; // 묘목이 자라는 데 필요한 시각
        for(int i=0 ; i<n ; i++)
            time[i] = Integer.parseInt(st.nextToken());
        int tmp = time[0];
        int answer = time[0];

        Arrays.sort(time, Collections.reverseOrder()); // 필요한 시간 기준 오름차순 정렬

        for (int t : time) {
            tmp--;
            if (tmp < t) {
                answer += t - tmp;
                tmp += t - tmp;
            }
        }

        System.out.println(answer+1);

        bf.close();
        System.exit(0);
    }
}