// BOJ - 22233
// Problem Sheet - https://www.acmicpc.net/problem/22233

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int numberOfKeywords = Integer.parseInt(st.nextToken());
        int numberOfBlogPosts = Integer.parseInt(st.nextToken());
        Map<String, Boolean> usageCheckMapper = new HashMap<>();

        int numberOfUnused = numberOfKeywords;
        for(int i=0 ; i<numberOfKeywords ; i++) {
            usageCheckMapper.put(bf.readLine(), false);
        }

        for(int i=0 ; i<numberOfBlogPosts ; i++) {
            String[] keywords = bf.readLine().split(",");
            for(String keyword : keywords) {
                if(usageCheckMapper.containsKey(keyword) && !usageCheckMapper.get(keyword)) {
                    usageCheckMapper.put(keyword, true);
                    numberOfUnused--;
                }
            }
            sb.append(numberOfUnused).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}