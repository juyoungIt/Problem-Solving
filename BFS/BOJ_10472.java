// BOJ - 10472
// Problem Sheet - https://www.acmicpc.net/problem/10472

import java.util.*;
import java.io.*;

class bStatus {
    private final String status; // 보드의 상태를 나타내는 정수코드
    private final int depth;  // 탐색의 깊이 (BFS)

    public bStatus(String status, int depth) {
        this.status = status;
        this.depth = depth;
    }

    public String getStatus() { return this.status; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        for(int i=0 ; i<tcSize ; i++) {
            StringBuilder dest = new StringBuilder();
            for(int j=0 ; j<3 ; j++)
                dest.append(getIntCode(bf.readLine()));
            System.out.println(bfs(dest.toString()));
        }

        bf.close();
        System.exit(0);
    }

    static int bfs(String dest) {
        Queue<bStatus> queue = new LinkedList<>(); // bfs에 사용하는 queue
        HashSet<String> generated = new HashSet<>(); // 발생한 상태들을 저장
        int result = 0;

        generated.add("000000000"); // 모두 흰색인 상태
        queue.add(new bStatus("000000000", 0));
        while(!queue.isEmpty()) {
            String curStatus = queue.peek().getStatus();
            int curDepth = queue.peek().getDepth();
            if(curStatus.equals(dest)) {
                result = curDepth;
                break;
            }
            for(int i=0 ; i<3 ; i++) {
                for(int j=0 ; j<3 ; j++) {
                    String tmp = clickButton(curStatus, j, i);
                    if(!generated.contains(tmp)) {
                        generated.add(tmp);
                        queue.add(new bStatus(tmp, curDepth+1));
                    }
                }
            }
            queue.poll();
        }
        return result;
    }

    static String clickButton(String curStatus, int x, int y) {
        StringBuilder sb = new StringBuilder(curStatus);
        reverse(sb, 3*y+x);
        if(validation(x+1, y)) reverse(sb, 3*y+x+1); // 동
        if(validation(x-1, y)) reverse(sb, 3*y+x-1); // 서
        if(validation(x, y+1)) reverse(sb, 3*(y+1)+x); // 남
        if(validation(x, y-1)) reverse(sb, 3*(y-1)+x); // 북
        return sb.toString();
    }

    static void reverse(StringBuilder sb, int idx) {
        if(sb.charAt(idx) == '1') sb.setCharAt(idx, '0');
        else sb.setCharAt(idx, '1');
    }

    static String getIntCode(String bString) {
        bString = bString.replace('*', '1');
        bString = bString.replace('.', '0');
        return bString;
    }

    static boolean validation(int x, int y) { return (x>=0 && y>=0 && x<3 && y<3); }
}