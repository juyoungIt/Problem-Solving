// BOJ - 17608
// Problem Sheet - https://www.acmicpc.net/problem/17608

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int numberOfRod = Integer.parseInt(bf.readLine());
        List<Integer> heights = new ArrayList<>(numberOfRod);
        int maxHeight = 0;
        for(int i=0 ; i<numberOfRod ; i++) {
            heights.add(Integer.parseInt(bf.readLine()));
        }

        for(int i=heights.size()-1 ; i>=0 ; i--) {
            int curHeight = heights.get(i);
            if(curHeight > maxHeight) {
                maxHeight = curHeight;
                result++;
            }
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}