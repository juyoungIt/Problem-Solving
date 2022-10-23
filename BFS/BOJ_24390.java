// BOJ - 24390
// Problem Sheet - https://www.acmicpc.net/problem/24390

import java.util.*;
import java.io.*;

class Node {
    private final int curTime;
    private final int depth;
    private final boolean started; // 조리시작 여부

    public Node(int curTime, int depth, boolean started) {
        this.curTime = curTime;
        this.depth = depth;
        this.started = started;
    }

    public int getCurTime() { return this.curTime; }
    public int getDepth() { return this.depth; }
    public boolean getStarted() { return this.started; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] timeStr = bf.readLine().split(":");
        int target = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);

        System.out.println(bfs(target));
        bf.close();
        System.exit(0);
    }

    static int bfs(int target) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Integer> generated = new HashSet<>(); // 탐색간 발생한 수를 유지 (비효율적 탐색 피하기 위함)
        int[] time_units = {600, 60, 30, 10}; // 각 버튼이 가지는 단위시간
        int result = 0;

        generated.add(0);
        queue.add(new Node(0, 0, false));
        while(!queue.isEmpty()) {
            int curTime = queue.peek().getCurTime();
            int curDepth = queue.peek().getDepth();
            boolean started = queue.peek().getStarted();
            if(curTime == target) {
                result = curDepth;
                if(!started) result++;
                break;
            }
            for(int i=0 ; i<4 ; i++) {
                int tTime = curTime + time_units[i];
                if(tTime <= target && !generated.contains(tTime)) {
                    if(i == 2) started = true;
                    generated.add(tTime);
                    queue.add(new Node(tTime, curDepth+1, started));
                }
            }
            queue.poll();
        }
        return result;
    }
}