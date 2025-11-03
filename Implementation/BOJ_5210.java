// BOJ - 5210
// Problem Sheet - https://www.acmicpc.net/problem/5210

import java.util.*;
import java.io.*;

public class Main {

    private static final String FORMAT = "Data Set %d:";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=k ; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] buildings = new String[n];
            for (int j=0 ; j<n ; j++) {
                buildings[j] = br.readLine();
            }
            String code = br.readLine();
            sb.append(String.format(FORMAT, i)).append("\n");
            for (String building: buildings) {
                if (isValid(building, code)) {
                    sb.append(building).append("\n");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isValid(String building, String code) {
        building = building.toLowerCase();
        code = code.toLowerCase();
        int index = 0;
        for (int i=0 ; i<building.length() ; i++) {
            if (index >= code.length()) return true;
            if (building.charAt(i) == code.charAt(index)) {
                index++;
            }
        }
        return index >= code.length();
    }

}
