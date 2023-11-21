// BOJ - 3055
// Problem Sheet - https://www.acmicpc.net/problem/3055

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private final char id;
        private final int x;
        private final int y;
        private final int t;

        public Node(char id, int x, int y, int t) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.t = t;
        }

        public char getId() { return this.id; }

        public int getX() { return this.x; }

        public int getY() { return this.y; }

        public int getT() { return this.t; }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        boolean[][] isVisit = new boolean[r][c];
        Queue<Node> queue = new LinkedList<>();
        Node src = null;
        for(int i=0 ; i<r ; i++) {
            String row = br.readLine();
            for(int j=0 ; j<c ; j++) {
                char id = row.charAt(j);
                if(isWater(id)) {
                    queue.add(new Node(id, j, i, 0));
                }
                if(isHedgehog(id)) {
                    src = new Node(id, j, i, 0);
                    isVisit[i][j] = true;
                }
                map[i][j] = id;
            }
        }
        queue.add(src);

        int result = pathSearch(map, queue, isVisit);
        System.out.println(result == -1 ? "KAKTUS" : result);

        br.close();
        System.exit(0);
    }

    private static int pathSearch(char[][] map, Queue<Node> queue, boolean[][] isVisit) {
        int[] xi = { -1, 0, 1, 0 };
        int[] yi = { 0, -1, 0, 1 };

        int fastestTime = -1;
        while(!queue.isEmpty()) {
            Node cur = queue.peek();
            if(isShelter(cur.getId())) {
                fastestTime = cur.getT();
                break;
            }
            if(isWater(cur.getId())) {
                for(int i=0 ; i<4 ; i++) {
                    int newX = cur.getX() + xi[i];
                    int newY = cur.getY() + yi[i];
                    if(isValid(newX, newY, map[0].length, map.length) && isEmpty(map[newY][newX])) {
                        map[newY][newX] = cur.getId();
                        queue.add(new Node(cur.getId(), newX, newY, cur.getT() + 1));
                    }
                }
            }
            if(isHedgehog(cur.getId())){
                for(int i=0 ; i<4 ; i++) {
                    int newX = cur.getX() + xi[i];
                    int newY = cur.getY() + yi[i];
                    if(isValid(newX, newY, map[0].length, map.length)
                            && !isVisit[newY][newX]
                            && (isEmpty(map[newY][newX]) || isShelter(map[newY][newX]))) {
                        isVisit[newY][newX] = true;
                        if(isEmpty(map[newY][newX])) {
                            map[newY][newX] = cur.getId();
                            queue.add(new Node(cur.getId(), newX, newY, cur.getT() + 1));
                        }
                        if(isShelter(map[newY][newX])) {
                            queue.add(new Node('D', newX, newY, cur.getT() + 1));
                        }
                    }
                }
            }
            queue.poll();
        }
        return fastestTime;
    }

    private static boolean isWater(char id) {
        return id == '*';
    }

    private static boolean isEmpty(char id) {
        return id == '.';
    }

    private static boolean isShelter(char id) {
        return id == 'D';
    }

    private static boolean isHedgehog(char id) { return id == 'S'; }

    private static boolean isValid(int x, int y, int c, int r) {
        return x>=0 && y>=0 && x<c && y<r;
    }

}