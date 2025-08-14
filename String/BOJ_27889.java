// BOJ - 27889
// Problem Sheet - https://www.acmicpc.net/problem/27889

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> gec = new HashMap<>();
        gec.put("NLCS", "North London Collegiate School");
        gec.put("BHA", "Branksome Hall Asia");
        gec.put("KIS", "Korea International School");
        gec.put("SJA", "St. Johnsbury Academy");
        String name = br.readLine();
        System.out.println(gec.get(name));
        br.close();
    }
}