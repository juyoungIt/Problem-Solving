// BOJ - 2628
// Problem Sheet - https://www.acmicpc.net/problem/2628

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int cuttingCount = Integer.parseInt(br.readLine());
        List<Integer> w = new ArrayList<>();
        w.add(0);
        w.add(height);
        List<Integer> h = new ArrayList<>();
        h.add(0);
        h.add(width);
        for (int i=0 ; i<cuttingCount ; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int cuttingPoint = Integer.parseInt(st.nextToken());
            if (dir == 0) {
                w.add(cuttingPoint);
            } else {
                h.add(cuttingPoint);
            }
        }
        w.sort(Comparator.reverseOrder());
        h.sort(Comparator.reverseOrder());

        int maxW = 0;
        int maxH = 0;
        for (int i=0 ; i<w.size()-1 ; i++) {
            maxW = Math.max(maxW, w.get(i) - w.get(i + 1));
        }
        for (int i=0 ; i<h.size()-1 ; i++) {
            maxH = Math.max(maxH, h.get(i) - h.get(i + 1));
        }
        System.out.println(maxW * maxH);

        br.close();
    }
}