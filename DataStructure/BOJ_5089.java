// BOJ - 5089
// Problem Sheet - https://www.acmicpc.net/problem/5089

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<String> towns = new HashSet<>();

        int curWeeks = 1;
        while(true) {
            int numberOfTowns = Integer.parseInt(bf.readLine());
            if(numberOfTowns == 0) {
                break;
            }
            for(int i=0 ; i<numberOfTowns ; i++) {
                towns.add(bf.readLine());
            }
            sb.append("Week ")
                    .append(curWeeks++)
                    .append(" ")
                    .append(towns.size())
                    .append("\n");
            towns.clear();
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}