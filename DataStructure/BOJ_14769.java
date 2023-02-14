// BOJ - 14769
// Problem Sheet - https://www.acmicpc.net/problem/14769

import java.util.*;
import java.io.*;

public class Main {

    static class Cup implements Comparable<Cup> {
        private final String color;
        private final int radius;

        public Cup(String color, int radius) {
            this.color = color;
            this.radius = radius;
        }

        public String getColor() { return this.color; }
        public int getRadius() { return this.radius; }

        @Override
        public int compareTo(Cup cup) {
            return Integer.compare(this.radius, cup.getRadius());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> radiusMapper = new HashMap<>();

        int cupCount = Integer.parseInt(bf.readLine()); // 컵의 갯수
        List<Cup> cups = new ArrayList<>(cupCount);
        for(int i=0 ; i<cupCount ; i++) {
            String[] sensorValues = bf.readLine().split(" ");
            if(isNumeric(sensorValues[1])) {
                radiusMapper.put(sensorValues[0], Integer.parseInt(sensorValues[1]));
            } else {
                radiusMapper.put(sensorValues[1], Integer.parseInt(sensorValues[0])/2);
            }
        }

        for(Map.Entry<String, Integer> entry : radiusMapper.entrySet()) {
            cups.add(new Cup(entry.getKey(), entry.getValue()));
        }
        Collections.sort(cups);

        for(Cup cup : cups) {
            System.out.println(cup.getColor());
        }

        bf.close();
        System.exit(0);
    }

    static boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}