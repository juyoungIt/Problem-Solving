// BOJ - 13700
// Problem Sheet - https://www.acmicpc.net/problem/13700

import java.util.*;
import java.io.*;

class Location {
    private final int index; // 현 위치의 인덱스
    private final int depth; // 현 위치의 탐색 depth

    public Location(int index, int depth) {
        this.index = index;
        this.depth = depth;
    }

    public int getIndex() { return this.index; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        boolean isReached = false; // 탈출 가능여부
        int answer = 0;

        int n = Integer.parseInt(st.nextToken()); // 건물의 수
        int[] buildings = new int[n+1]; // 건물의 정보를 저장

        int s = Integer.parseInt(st.nextToken()); // 털이한 금은방의 위치
        int d = Integer.parseInt(st.nextToken()); // 대도X 집의 위치

        int f = Integer.parseInt(st.nextToken()); // 앞으로 한 번에 달릴 수 있는 건물의 수
        int b = Integer.parseInt(st.nextToken()); // 뒤로 한 번에 달릴 수 있는 건물의 수

        int k = Integer.parseInt(st.nextToken()); // 경찰서의 수
        if(k > 0) {
            st = new StringTokenizer(bf.readLine());
            for(int i=0 ; i<k ; i++)
                buildings[Integer.parseInt(st.nextToken())] = 1;
        }

        Queue<Location> queue = new LinkedList<>(); // bfs를 위한 queue
        boolean[] visit = new boolean[n+1]; // 각 건물에 대한 방문정보 저장
        int[] xi = {f, -b}; // x-increment

        visit[s] = true;
        queue.add(new Location(s, 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getIndex();
            int curDepth = queue.peek().getDepth();
            if(curX == d) {
                isReached = true;
                answer = curDepth;
                break;
            }
            for(int i=0 ; i<2 ; i++) {
                int tx = curX + xi[i];
                int tDepth = curDepth + 1;
                if(validation(tx, n) && buildings[tx] == 0 && !visit[tx]) {
                    visit[tx] = true;
                    queue.add(new Location(tx, tDepth));
                }
            }
            queue.poll();
        }

        System.out.println(isReached ? answer : "BUG FOUND");

        bf.close();
        System.exit(0);
    }

    static boolean validation(int x, int n) { return (x>=1 && x<=n); }
}