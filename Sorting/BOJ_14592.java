// BOJ - 14592
// Problem Sheet - https://www.acmicpc.net/problem/14592

import java.util.*;
import java.io.*;

public class Main {

    static class Participant implements Comparable<Participant> {
        int number;
        int scoreSum;
        int submissionCount;
        int lastUploadTime;

        public Participant(int number, int scoreSum, int submissionCount, int lastUploadTime) {
            this.number = number;
            this.scoreSum = scoreSum;
            this.submissionCount = submissionCount;
            this.lastUploadTime = lastUploadTime;
        }

        @Override
        public int compareTo(Participant p) {
            if (p.scoreSum == scoreSum) {
                if (p.submissionCount == submissionCount) {
                    return lastUploadTime - p.lastUploadTime;
                }
                return submissionCount - p.submissionCount;
            }
            return p.scoreSum - scoreSum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Participant> pQueue = new PriorityQueue<>();
        for (int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            pQueue.add(new Participant(i, s, c, l));
        }
        System.out.println(pQueue.peek().number);
        br.close();
    }
}