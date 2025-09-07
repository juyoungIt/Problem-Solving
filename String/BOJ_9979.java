// BOJ - 9979
// Problem Sheet - https://www.acmicpc.net/problem/9979

import java.util.*;
import java.io.*;

public class Main {

    static class Dieter implements Comparable<Dieter> {
        String name;
        int weight;

        public Dieter(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() { return this.name; }
        public int getWeight() { return this.weight; }

        @Override
        public int compareTo(Dieter d) {
            return d.getWeight() - this.weight;
        }
    }

    static final String START = "START", END = "END";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Dieter> dieters = new ArrayList<>();
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            if (input.equals(START)) {
                dieters = new ArrayList<>();
            } else if (input.equals(END)) {
                Collections.sort(dieters);
                for (Dieter dieter : dieters) {
                    sb.append(dieter.getName()).append("\n");
                }
                sb.append("\n");
            } else {
                String[] row = input.split(" ");
                String name = row[0];
                int days = Integer.parseInt(row[1]);
                int startWeight = Integer.parseInt(row[2]);
                dieters.add(new Dieter(name, startWeight - days));
            }
        }
        System.out.println(sb);
        br.close();
    }
    
}