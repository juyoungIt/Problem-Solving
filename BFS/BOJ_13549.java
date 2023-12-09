// BOJ - 13549
// Problem Sheet - https://www.acmicpc.net/problem/13549

import java.util.*;
import java.io.*;

public class Main {

    static class Status {
        private final int location;
        private final int time;

        public Status(int location, int time) {
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
        boolean[] isVisit = new boolean[100_001];

        Queue<Status> queue = new LinkedList<>();
        queue.add(new Status(n, 0));
        isVisit[n] = true;
        while(!queue.isEmpty()) {
            Status curStatus = queue.peek();
            if(curStatus.getLocation() == k) {
                System.out.println(curStatus.getTime());
                break;
            }
            if(isValid(curStatus.getLocation() * 2)
                    && !isVisit[curStatus.getLocation() * 2]) {
                queue.add(new Status(curStatus.getLocation() * 2, curStatus.getTime()));
                isVisit[curStatus.getLocation() * 2] = true;
            }
            if(isValid(curStatus.getLocation() - 1)
                    && !isVisit[curStatus.getLocation() - 1]) {
                queue.add(new Status(curStatus.getLocation() - 1, curStatus.getTime() + 1));
                isVisit[curStatus.getLocation() - 1] = true;
            }
            if(isValid(curStatus.getLocation() + 1)
                    && !isVisit[curStatus.getLocation() + 1]) {
                queue.add(new Status(curStatus.getLocation() + 1, curStatus.getTime() + 1));
                isVisit[curStatus.getLocation() + 1] = true;
            }
            queue.poll();
        }

        br.close();
        System.exit(0);
    }

    private static boolean isValid(int location) {
        return location >= 0 && location <= 100_000;
    }
}