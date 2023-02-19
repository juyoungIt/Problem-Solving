// BOJ - 4351
// Problem Sheet - https://www.acmicpc.net/problem/4351

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> wordMapper = new HashMap<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int numberOfWords = Integer.parseInt(st.nextToken());
        int numberOfDescriptions = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<numberOfWords ; i++) {
            String[] wordInfos = bf.readLine().split(" ");
            wordMapper.put(wordInfos[0], Integer.parseInt(wordInfos[1]));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<numberOfDescriptions ; i++) {
            int value = 0;
            sb.setLength(0);
            while(true) {
                String description = bf.readLine();
                if(description.equals(".")) {
                    break;
                }
                sb.append(description).append(" ");
            }
            String[] tokens = sb.toString().split(" ");
            for(String token : tokens) {
                value += getValue(wordMapper, token);
            }
            System.out.println(value);
        }

        bf.close();
        System.exit(0);
    }

    static int getValue(Map<String, Integer> mapper, String name) {
        if(!mapper.containsKey(name)) {
            return 0;
        }
        return mapper.get(name);
    }
}