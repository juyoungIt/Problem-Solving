// BOJ - 29723
// Problem Sheet - https://www.acmicpc.net/problem/29723

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Map<String, Integer> scoreMapper = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            scoreMapper.put(name, score);
        }

        int minScore = 0;
        int maxScore = 0;
        for(int i=0 ; i<k ; i++) {
            String publicName = br.readLine();
            minScore += scoreMapper.get(publicName);
            scoreMapper.remove(publicName);
        }
        maxScore = minScore;

        List<Integer> scores = new LinkedList<>();
        for(int score : scoreMapper.values()) {
            scores.add(score);
        }
        Collections.sort(scores);

        for(int i=0 ; i<m-k ; i++) {
            minScore += scores.get(i);
            maxScore += scores.get(n-k-i-1);
        }
        System.out.println(minScore + " " + maxScore);

        br.close();
        System.exit(0);
    }
}