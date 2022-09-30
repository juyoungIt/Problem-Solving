// BOJ - 18232
// Problem Sheet - https://www.acmicpc.net/problem/18232

import java.util.*;
import java.io.*;

class Location {
    private final int index; // 정거장의 번호
    private final int depth; // 정거장의 탐색 Depth

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

        // 정거장의 수, 연결정보의 수를 입력
        int n = Integer.parseInt(st.nextToken()); // 텔레포트 정거장의 수
        int m = Integer.parseInt(st.nextToken()); // 텔레포트 연결정보의 수
        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();

        // 주예, 방주의 위치 정보를 입력
        st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken()); // 주예의 위치 (start)
        int e = Integer.parseInt(st.nextToken()); // 방주의 위치 (target)

        // 연결정보를 바탕으로 각 정거장에 대한 adjacency list를 구성함
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            al[x].add(y);
            al[y].add(x);
        }

        // bfs를 수행하여 솔루션을 산출함
        System.out.println(bfs(al, s, e));

        bf.close();
        System.exit(0);
    }

    static int bfs(ArrayList<Integer>[] al, int start, int target) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 위해 사용하는 queue
        boolean[] visit = new boolean[al.length]; // 각 위치에 대한 방문정보
        int[] xi = {-1, 1}; // x-increment
        int result = 0; // 목표지점에 도달하는 데 필요한 최소 depth

        visit[start] = true;
        queue.add(new Location(start, 0));
        while(!queue.isEmpty()) {
            int curIndex = queue.peek().getIndex();
            int curDepth = queue.peek().getDepth();
            if(curIndex == target) {
                result = curDepth;
                break;
            }
            // 앞 뒤로 움직이는 경우
            for(int i=0 ; i<2 ; i++) {
                int tIndex = curIndex + xi[i];
                int tDepth = curDepth + 1;
                if(validation(tIndex, al.length-1) && !visit[tIndex]) {
                    visit[tIndex] = true;
                    queue.add(new Location(tIndex, tDepth));
                }
            }
            // 텔레포트를 통하여 움직이는 경우
            for(int index : al[curIndex]) {
                if(!visit[index]) {
                    visit[index] = true;
                    queue.add(new Location(index, curDepth+1));
                }
            }
            queue.poll();
        }
        return result;
    }

    static boolean validation(int x, int n) {
        return (x>=1 && x<=n);
    }
}