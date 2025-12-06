// BOJ - 30087
// Problem Sheet - https://www.acmicpc.net/problem/30087

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        map.put("Algorithm", "204");
        map.put("DataAnalysis", "207");
        map.put("ArtificialIntelligence", "302");
        map.put("CyberSecurity", "B101");
        map.put("Network", "303");
        map.put("Startup", "501");
        map.put("TestStrategy", "105");
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            String name = br.readLine();
            sb.append(map.get(name)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
