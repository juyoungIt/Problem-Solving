// BOJ - 1889
// Problem Sheet - https://www.acmicpc.net/problem/1889

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] indegree;
    private static boolean[] isVisit;
    private static List<Integer>[] al;
    private static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        setup();
        topologicalSort();
        System.out.println(getResultStr());
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        al = new List[n + 1];
        isVisit = new boolean[n + 1];
        indegree = new int[n + 1];
        pq = new PriorityQueue<>();
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }
        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al[i].add(a);
            al[i].add(b);
            indegree[a]++;
            indegree[b]++;
        }

        for(int i=1 ; i<=n ; i++) {
            if(indegree[i] < 2) {
                pq.add(i);
            }
        }

        br.close();
    }

    private static void topologicalSort() {
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            if(isVisit[cur]) continue;
            isVisit[cur] = true;
            for(int next : al[cur]) {
                indegree[next]--;
                if(indegree[next] < 2) {
                    pq.add(next);
                }
            }
        }
    }

    private static String getResultStr() {
        StringBuilder sb = new StringBuilder();
        List<Integer> participants = new LinkedList<>();

        for(int i=1 ; i<=n ; i++) {
            if(indegree[i] == 2) {
                participants.add(i);
            }
        }

        sb.append(participants.size()).append("\n");
        for(int participant : participants) {
            sb.append(participant).append(" ");
        }

        return sb.toString();
    }
}