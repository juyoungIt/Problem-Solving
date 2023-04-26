// BOJ - 14713
// Problem Sheet - https://www.acmicpc.net/problem/14713

import java.util.*;
import java.io.*;

public class Main {

    private static final String POSSIBLE = "Possible";
    private static final String IMPOSSIBLE = "Impossible";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> indexMapper = new HashMap<>();
        boolean isValid = true;

        int numberOfBirds = Integer.parseInt(bf.readLine());
        List<Queue<String>> messages = new ArrayList<>(numberOfBirds);
        for(int i=0 ; i<numberOfBirds ; i++) {
            messages.add(new LinkedList<>());
        }

        for(int i=0 ; i<numberOfBirds ; i++) {
            String[] tokens = bf.readLine().split(" ");
            for(String token : tokens) {
                messages.get(i).add(token);
                indexMapper.put(token, i);
            }
        }

        String[] tokens = bf.readLine().split(" ");
        if(tokens.length != indexMapper.size()) {
            isValid = false;
        } else {
            for(String token : tokens) {
                if(!indexMapper.containsKey(token)
                        || messages.get(indexMapper.get(token)).isEmpty()
                        || !messages.get(indexMapper.get(token)).peek().equals(token)) {
                    isValid = false;
                    break;
                }
                messages.get(indexMapper.get(token)).poll();
            }
        }

        System.out.println((isValid) ? POSSIBLE : IMPOSSIBLE);

        bf.close();
        System.exit(0);
    }
}