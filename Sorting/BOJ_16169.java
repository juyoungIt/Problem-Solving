// BOJ - 16169
// Problem Sheet - https://www.acmicpc.net/problem/16169

import java.util.*;
import java.io.*;

public class Main {

    static class Computer {
        private final int level;
        private final int speed;

        public Computer(int level, int speed) {
            this.level = level;
            this.speed = speed;
        }

        public int getLevel() { return this.level; }
        public int getSpeed() { return this.speed; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Computer[] computers = new Computer[n + 1];
        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            computers[i] = new Computer(level, speed);
        }

        List<Integer>[] al = new List[n + 1];
        int[] prevComCnt = new int[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }

        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                if(i == j) continue;
                if(computers[i].getLevel() + 1 == computers[j].getLevel()) {
                    al[i].add(j);
                    prevComCnt[j]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] baseTimes = new int[n + 1];
        int[] doneTimes = new int[n + 1];
        for(int i=1 ; i<=n ; i++) {
            if(prevComCnt[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int curCom = queue.poll();
            int doneTime = baseTimes[curCom] + computers[curCom].getSpeed();
            doneTimes[curCom] = doneTime;
            for(int nextCom : al[curCom]) {
                doneTime += (int)Math.pow(curCom - nextCom, 2);
                if(doneTimes[curCom] < doneTime) {
                    doneTimes[curCom] = doneTime;
                }
                if(baseTimes[nextCom] < doneTime) {
                    baseTimes[nextCom] = doneTime;
                }
                prevComCnt[nextCom]--;
                if(prevComCnt[nextCom] == 0) {
                    queue.add(nextCom);
                }
                doneTime -= (int)Math.pow(curCom - nextCom, 2);
            }
        }

        Arrays.sort(doneTimes);
        System.out.println(doneTimes[n]);

        br.close();
        System.exit(0);
    }
}