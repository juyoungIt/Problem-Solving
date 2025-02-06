// BOJ - 6799
// Problem Sheet - https://www.acmicpc.net/problem/6799

import java.util.*;
import java.io.*;

public class Main {

    static class Computer implements Comparable<Computer> {
        private final String name;
        private final int ram;
        private final int cpu;
        private final int disk;

        public Computer(String name, int ram, int cpu, int disk) {
            this.name = name;
            this.ram = ram;
            this.cpu = cpu;
            this.disk = disk;
        }

        public String getName() { return this.name; }
        public int getPreference() { return 2 * ram + 3 * cpu + disk; }

        @Override
        public int compareTo(Computer c) {
            if (this.getPreference() == c.getPreference()) {
                return this.getName().compareTo(c.getName());
            }
            return c.getPreference() - this.getPreference();
        }
    }

    private static int n;
    private static Computer[] computers;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        computers = new Computer[n];
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            String name = row[0];
            int R = Integer.parseInt(row[1]);
            int S = Integer.parseInt(row[2]);
            int D = Integer.parseInt(row[3]);
            computers[i] = new Computer(name, R, S, D);
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(computers);
        for (int i=0 ; i<Math.min(n, 2) ; i++) {
            sb.append(computers[i].getName()).append("\n");
        }
        return sb.toString();
    }
}