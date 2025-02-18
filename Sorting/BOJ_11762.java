// BOJ - 11762
// Problem Sheet - https://www.acmicpc.net/problem/11762

import java.util.*;
import java.io.*;

public class Main {

    private static final int[] boxes = new int[6];
    private static int towerA, towerB;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<6 ; i++) {
            boxes[i] = Integer.parseInt(row[i]);
        }
        Arrays.sort(boxes);
        towerA = Integer.parseInt(row[6]);
        towerB = Integer.parseInt(row[7]);
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<boxes.length-2 ; i++) {
            for (int j=i+1 ; j<boxes.length-1 ; j++) {
                for (int k=j+1 ; k<boxes.length ; k++) {
                    int totalHeight = boxes[i] + boxes[j] + boxes[k];
                    if (totalHeight == towerA) {
                        sb.append(String.format("%d %d %d ", boxes[k], boxes[j], boxes[i]));
                        for (int l=boxes.length-1 ; l>=0 ; l--) {
                            if (l == i || l == j || l == k) continue;
                            sb.append(boxes[l]).append(" ");
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}