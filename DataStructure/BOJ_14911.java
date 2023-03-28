// BOJ - 14911
// Problem Sheet - https://www.acmicpc.net/problem/14911

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int targetNumber = Integer.parseInt(bf.readLine());

        List<Integer> numbers = new ArrayList<>(inputs.length);
        for(String input : inputs) {
            numbers.add(Integer.parseInt(input));
        }
        Collections.sort(numbers);

        Set<String> pairs = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<numbers.size()-1 ; i++) {
            for(int j=i+1 ; j<numbers.size() ; j++) {
                if(numbers.get(i) + numbers.get(j) == targetNumber) {
                    sb.append(numbers.get(i)).append(" ").append(numbers.get(j));
                    pairs.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        for(String pair : pairs) {
            System.out.println(pair);
        }
        System.out.println(pairs.size());

        bf.close();
        System.exit(0);
    }
}