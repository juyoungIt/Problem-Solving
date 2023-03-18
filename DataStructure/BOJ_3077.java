// BOJ - 3077
// Problem Sheet - https://www.acmicpc.net/problem/3077

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> sequenceMapper = new HashMap<>();

        int numberOfCombats = Integer.parseInt(bf.readLine());
        int numberOfCorrect = 0;
        int totalCombinationCount = (numberOfCombats * (numberOfCombats-1)) / 2;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfCombats ; i++) {
            sequenceMapper.put(st.nextToken(), i);
        }

        st = new StringTokenizer(bf.readLine());
        List<String> guess = new ArrayList<>(numberOfCombats);
        for(int i=0 ; i<numberOfCombats ; i++) {
            guess.add(st.nextToken());
        }

        for(int i=0 ; i<numberOfCombats-1 ; i++) {
            for(int j=i+1 ; j<numberOfCombats ; j++) {
                String nameA = guess.get(i);
                String nameB = guess.get(j);
                if(sequenceMapper.get(nameA) < sequenceMapper.get(nameB)) {
                    numberOfCorrect++;
                }
            }
        }

        System.out.println(numberOfCorrect + "/" + totalCombinationCount);

        bf.close();
        System.exit(0);
    }
}