// BOJ - 1717
// Problem Sheet - https://www.acmicpc.net/problem/1717

import java.util.*;
import java.io.*;

public class Main {

    private static final String VALID = "YES";
    private static final String INVALID = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int numberOfSet = Integer.parseInt(st.nextToken()) + 1;
        int numberOfOperation = Integer.parseInt(st.nextToken());
        Map<Integer, Set<Integer>> setMapper = new HashMap<>();
        for(int i=0 ; i<numberOfSet ; i++) {
            setMapper.put(i, new HashSet<>());
            setMapper.get(i).add(i);
        }

        for(int i=0 ; i<numberOfOperation ; i++) {
            st = new StringTokenizer(bf.readLine());
            int operationType = Integer.parseInt(st.nextToken());
            int operandA = Integer.parseInt(st.nextToken());
            int operandB = Integer.parseInt(st.nextToken());

            if(operationType == 0) {
                union(setMapper, operandA, operandB);
            } else if(operationType == 1) {
                boolean result = isBothExist(setMapper, operandA, operandB);
                sb.append((result) ? VALID : INVALID).append("\n");
            } else {
                throw new IllegalArgumentException("Invalid oepration type");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static void union(Map<Integer, Set<Integer>> setMapper, int operandA, int operandB) {
        setMapper.get(operandA).addAll(setMapper.get(operandB));
        setMapper.put(operandB, setMapper.get(operandA));
    }

    private static boolean isBothExist(Map<Integer, Set<Integer>> setMapper, int operandA, int operandB) {
        return setMapper.get(operandA) == setMapper.get(operandB);
    }
}