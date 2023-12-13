// BOJ - 14567
// Problem Sheet - https://www.acmicpc.net/problem/14567

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] al = new List[n + 1];
        int[] prevSubjectCnt = new int[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            al[prev].add(next);
            prevSubjectCnt[next]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] finishSemester = new int[n + 1];
        for(int i=1 ; i<=n ; i++) {
            if(prevSubjectCnt[i] == 0) {
                queue.add(i);
                finishSemester[i] = 1;
            }
        }

        while(!queue.isEmpty()) {
            int curSubject = queue.poll();
            for(int subject : al[curSubject]) {
                prevSubjectCnt[subject]--;
                if(prevSubjectCnt[subject] == 0) {
                    queue.add(subject);
                    finishSemester[subject] = finishSemester[curSubject] + 1;
                }
            }
        }

        for(int i=1 ; i<=n ; i++) {
            sb.append(finishSemester[i]).append(" ");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}