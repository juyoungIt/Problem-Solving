// BOJ - 2358
// Problem Sheet - https://www.acmicpc.net/problem/2358

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int totalCount = 0;

        int numberOfPoints = Integer.parseInt(bf.readLine());
        Map<Integer, Integer> axisX = new HashMap<>();
        Map<Integer, Integer> axisY = new HashMap<>();
        for(int i=0 ; i<numberOfPoints ; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(!axisX.containsKey(x)) {
                axisX.put(x, 0);
            }
            axisX.put(x, axisX.get(x) + 1);
            if(!axisY.containsKey(y)) {
                axisY.put(y, 0);
            }
            axisY.put(y, axisY.get(y) + 1);
        }

        for(int count : axisX.values()) {
            if(count > 1) {
                totalCount++;
            }
        }

        for(int count : axisY.values()) {
            if(count > 1) {
                totalCount++;
            }
        }

        System.out.println(totalCount);

        bf.close();
        System.exit(0);
    }
}