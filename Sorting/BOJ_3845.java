// BOJ - 3845
// Problem Sheet - https://www.acmicpc.net/problem/3845

import java.util.*;
import java.io.*;

public class Main {

    private static final int WIDTH = 100, HEIGHT = 75;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] row = br.readLine().split(" ");
            int nx = Integer.parseInt(row[0]);
            int ny = Integer.parseInt(row[1]);
            double w = Double.parseDouble(row[2]);
            if (nx == 0 && ny == 0 && w == 0.0) break;
            double[] xi = Arrays.stream(br.readLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .sorted()
                    .toArray();
            double[] yi = Arrays.stream(br.readLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .sorted()
                    .toArray();
            sb.append(isValid(nx, ny, w, xi, yi) ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
        br.close();
	}

    private static boolean isValid(int nx, int ny, double w, double[] xi, double[] yi) {
        for (int i=0 ; i<nx-1 ; i++) {
            if (xi[i] + w < xi[i + 1]) {
                return false;
            }
        }
        for (int i=0 ; i<ny-1 ; i++) {
            if (yi[i] + w < yi[i + 1]) {
                return false;
            }
        }
        return !(xi[nx - 1] + w/2 < HEIGHT || yi[ny - 1] + w/2 < WIDTH);
    }
}
