// BOJ - 28781
// Problem Sheet - https://www.acmicpc.net/problem/28781

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> units = new HashMap<>();
        units.put("tera", 12); units.put("giga", 9); units.put("mega", 6);
        units.put("kilo", 3); units.put("deci", -1); units.put("centi", -2);
        units.put("milli", -3); units.put("micro", -6); units.put("nano", -9);
        units.put("meter", 0); units.put("^2", 0); units.put("^3", 0);

        String s = br.readLine();
        int result = 0;
        int start = 0, end = 0;
        while (end <= s.length()){
            String part = s.substring(start, end);
            if (!units.containsKey(part)) {
                end++;
                continue;
            }
            if (part.equals("^2") || part.equals("^3")) {
                int sn = part.charAt(1) - '0';
                result *= sn;
            } else {
                result += units.get(part);
            }
            start = end;
            end++;
        }

        System.out.println(result);
        br.close();
    }
}
