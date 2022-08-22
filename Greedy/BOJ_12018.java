// BOJ - 12018
// Problem Sheet - https://www.acmicpc.net/problem/12018

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 과목 수
        int m = Integer.parseInt(st.nextToken()); // 주어진 마일리지
        int[] point = new int[n]; // 각 과목 신청을 위해 필요한 최소 마일리지
        int answer = 0; // 신청 가능한 강의의 수

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken()); // 해당 과목에 신청한 인원 수
            int l = Integer.parseInt(st.nextToken()); // 해당 과목의 정원
            Integer[] points = new Integer[p]; // 각 학생들이 신청한 마일리지
            st = new StringTokenizer(bf.readLine());
            // 정원 미달인 경우
            if(p < l)
                point[i] = 1;
            // 정원 초과인 경우
            else {
                for(int j=0 ; j<p ; j++)
                    points[j] = (Integer.parseInt(st.nextToken()));
                Arrays.sort(points, Collections.reverseOrder()); // 마일리지 현황정렬 (내림차순)
                point[i] = points[l-1];
            }
        }

        // 필요한 마일리지 값을 오름차순 정렬
        Arrays.sort(point);

        for(int p : point) {
            if(m-p < 0)
                break;
            m -= p;
            answer++;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}