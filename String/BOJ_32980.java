// BOJ - 32980
// Problem Sheet - https://www.acmicpc.net/problem/32980

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long totalPrice = 0L;
        Map<Character, Integer> costs = new HashMap<>();
        String[] garbages = new String[n];
        for (int i=0 ; i<n ; i++) {
            garbages[i] = br.readLine();
        }
        String[] row = br.readLine().split(" ");
        costs.put('P', Integer.parseInt(row[0]));
        costs.put('C', Integer.parseInt(row[1]));
        costs.put('V', Integer.parseInt(row[2]));
        costs.put('S', Integer.parseInt(row[3]));
        costs.put('G', Integer.parseInt(row[4]));
        costs.put('F', Integer.parseInt(row[5]));
        costs.put('O', Integer.parseInt(br.readLine()));

        for (String garbage : garbages) {
            boolean isPure = true;
            char prev = garbage.charAt(0);
            for (int i=1 ; i<garbage.length() ; i++) {
                if (prev != garbage.charAt(i)) {
                    isPure = false;
                    break;
                }
            }
            long gCost = (long) costs.get('O') * garbage.length();
            if (isPure) {
                long rCost = (long) costs.get(prev) * garbage.length();
                totalPrice += Math.min(rCost, gCost);
            } else {
                totalPrice += gCost;
            }
        }

        System.out.println(totalPrice);
        br.close();
    }
}
