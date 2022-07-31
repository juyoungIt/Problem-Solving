// BOJ - 16435
// Problem Sheet - https://www.acmicpc.net/problem/16435

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 과일의 수
        int l = Integer.parseInt(st.nextToken()); // 뱀의 초기길이
        PriorityQueue<Integer> fHeights = new PriorityQueue<>(); // 과일의 높이 저장 - 오름차순
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            fHeights.add(Integer.parseInt(st.nextToken()));
        int answer = l;

        while(fHeights.size() > 0) {
            if(fHeights.peek() > answer)
                break;
            answer++; // 뱀위 길이 증가
            fHeights.poll(); // 해당 과일을 먹음
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}