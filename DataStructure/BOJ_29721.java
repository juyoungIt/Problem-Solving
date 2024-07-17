// BOJ - 29721
// Problem Sheet - https://www.acmicpc.net/problem/29721

import java.util.*;
import java.io.*;

public class Main {

    static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;
            Position p = (Position) o;
            return this.x == p.getX() && this.y == p.getY();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        int[] xi = {0, 0, -2, 2};
        int[] yi = {-2, 2, 0, 0};
        Set<Position> occupied = new HashSet<>();
        Set<Position> candidates = new HashSet<>();

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            occupied.add(new Position(x, y));
        }

        for (Position position : occupied) {
            for (int i=0 ; i<4 ; i++) {
                int moveX = position.getX() + xi[i];
                int moveY = position.getY() + yi[i];
                Position candidate = new Position(moveX, moveY);
                if (isValid(moveX, moveY, n) && !occupied.contains(candidate)) {
                    candidates.add(candidate);
                }
            }
        }

        System.out.println(candidates.size());

        br.close();
        System.exit(0);
    }

    private static boolean isValid(int x, int y, int n) {
        return x >= 1 && y >= 1 && x <= n && y <= n;
    }
}