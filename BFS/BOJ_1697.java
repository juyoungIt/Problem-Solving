// BOJ - 1697
// Problem Sheet - https://www.acmicpc.net/problem/1697

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private final int location;
        private final int time;

        public Node(int location, int time) {
            this.location = location;
            this.time = time;
        }

        public int getLocation() { return this.location; }
        public int getTime() { return this.time; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(searchFastestTime(n, k));

        br.close();
        System.exit(0);
    }

    private static int searchFastestTime(int src, int dest) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] isVisit = new boolean[100_001];
        int fastestTime = -1;

        queue.add(new Node(src, 0));
        isVisit[src] = true;
        while(!queue.isEmpty()) {
            Node cur = queue.peek();
            int curLocation = cur.getLocation();
            int curTime = cur.getTime();
            if(curLocation == dest) {
                fastestTime = curTime;
                break;
            }
            int newLocation = moveLeft(curLocation);
            if(isValid(newLocation) && !isVisit[newLocation]) {
                queue.add(new Node(newLocation, curTime + 1));
                isVisit[newLocation] = true;
            }
            newLocation = moveRight(curLocation);
            if(isValid(newLocation) && !isVisit[newLocation]) {
                queue.add(new Node(newLocation, curTime + 1));
                isVisit[newLocation] = true;
            }
            newLocation = teleport(curLocation);
            if(isValid(newLocation) && !isVisit[newLocation]) {
                queue.add(new Node(newLocation, curTime + 1));
                isVisit[newLocation] = true;
            }
            queue.poll();
        }
        return fastestTime;
    }

    private static boolean isValid(int location) {
        return location >= 0 && location <= 100_000;
    }

    private static int moveLeft(int curLocation) {
        return curLocation - 1;
    }

    private static int moveRight(int curLocation) {
        return curLocation + 1;
    }

    private static int teleport(int curLocation) {
        return curLocation * 2;
    }
}