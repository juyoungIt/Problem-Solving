// BOJ - 1931
// Problem Sheet - https://www.acmicpc.net/problem/1931

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numberOfMeetings = Integer.parseInt(bf.readLine());
        int[][] meetings = new int[numberOfMeetings][2];
        for(int i=0 ; i<numberOfMeetings ; i++) {
            st = new StringTokenizer(bf.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (m1, m2) -> {
            if(m1[1] == m2[1]) {
                return m1[0] - m2[0];
            }
            return m1[1] - m2[1];
        });

        int maxMeetingCount = 0;
        int latestTime = 0;
        for(int i=0 ; i<numberOfMeetings ; i++) {
            if(latestTime <= meetings[i][0]) {
                maxMeetingCount++;
                latestTime = meetings[i][1];
            }
        }

        System.out.println(maxMeetingCount);

        bf.close();
        System.exit(0);
    }
}