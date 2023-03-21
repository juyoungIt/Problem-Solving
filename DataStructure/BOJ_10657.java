// BOJ - 10657
// Problem Sheet - https://www.acmicpc.net/problem/10657

import java.util.*;
import java.io.*;

public class Main {

    static class Horse implements Comparable<Horse> {
        private final int location;
        private final int speed;

        public Horse(int location, int speed) {
            this.location = location;
            this.speed = speed;
        }

        public int getLocation() { return this.location; }
        public int getSpeed() { return this.speed; }

        @Override
        public int compareTo(Horse horse) {
            return Integer.compare(this.location, horse.getLocation()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Horse> horses = new PriorityQueue<>();
        StringTokenizer st;

        Stack<Integer> groups = new Stack<>();
        int numberOfHorses = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfHorses ; i++) {
            st = new StringTokenizer(bf.readLine());
            int location = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            horses.add(new Horse(location, speed));
        }

        while(!horses.isEmpty()) {
            if(groups.isEmpty() || groups.peek() >= horses.peek().getSpeed()) {
                groups.add(horses.poll().getSpeed());
                continue;
            }
            horses.poll();
        }

        System.out.println(groups.size());

        bf.close();
        System.exit(0);
    }
}