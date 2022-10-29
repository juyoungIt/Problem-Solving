// BOJ - 9204
// Problem Sheet - https://www.acmicpc.net/problem/9204

import java.util.*;
import java.io.*;

class Location {
    private final int x;
    private final int y;
    private final int depth; // 탐색의 depth

    private final ArrayList<String> path; // 이동경로

    public Location(int x, int y, int depth, ArrayList<String> path) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.path = path;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getDepth() { return this.depth; }

    public ArrayList<String> getPath() { return this.path; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        ArrayList<String>[] answer = new ArrayList[t];
        for(int i=0 ; i<t ; i++) {
            answer[i] = new ArrayList<>();
            boolean[][] visit = new boolean[9][9]; // 방문상태 유지
            st = new StringTokenizer(bf.readLine());
            int startX = getIndex(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int targetX = getIndex(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            bfs(answer[i], visit, startX, startY, targetX, targetY);
        }

        // 종합된 정답을 출력
        for(List<String> result : answer) {
            for(String s : result)
                System.out.print(s + " ");
            System.out.println();
        }

        bf.close();
        System.exit(0);
    }

    static void bfs(ArrayList<String> answer, boolean[][] visit, int startX, int startY, int targetX, int targetY) {
        Queue<Location> queue = new LinkedList<>();
        int[] xi = {-1, 1, 1, -1}; // x-increment
        int[] yi = {1, 1, -1, -1}; // y-increment
        boolean isReached = false;

        visit[startY][startX] = true;
        ArrayList<String> path = new ArrayList<>();
        path.add(getChar(startX)+"");
        path.add(Integer.toString(startY));
        queue.add(new Location(startX, startY, 0, path));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            ArrayList<String> curPath = queue.peek().getPath();
            if(curDepth > 4) break;
            if(curX == targetX && curY == targetY) {
                answer.add(curDepth+"");
                answer.addAll(curPath);
                isReached = true;
                break;
            }
            for(int i=0 ; i<4 ; i++) {
                int tx = curX+xi[i], ty = curY+yi[i];
                while(validation(tx, ty, 8)) {
                    ArrayList<String> tPath = new ArrayList<>(curPath);
                    if(!visit[ty][tx]) {
                        visit[ty][tx] = true;
                        tPath.add(getChar(tx)+"");
                        tPath.add(Integer.toString(ty));
                        queue.add(new Location(tx, ty, curDepth+1, tPath));
                    }
                    tx = tx+xi[i];
                    ty = ty+yi[i];
                }
            }
            queue.poll();
        }
        if(!isReached) answer.add("Impossible");
    }

    static int getIndex(String s) { return (int)s.charAt(0) - 64; }

    static char getChar(int i) { return (char)(i+64); }

    static boolean validation(int x, int y, int n) { return (x>0 && y>0 && x<=n && y<=n); }
}