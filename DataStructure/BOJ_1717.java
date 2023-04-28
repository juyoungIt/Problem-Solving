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
        int[] nodes = new int[numberOfSet];
        for(int i=1 ; i<numberOfSet ; i++) {
            nodes[i] = i;
        }

        for(int i=0 ; i<numberOfOperation ; i++) {
            st = new StringTokenizer(bf.readLine());
            int operationType = Integer.parseInt(st.nextToken());
            int operandA = Integer.parseInt(st.nextToken());
            int operandB = Integer.parseInt(st.nextToken());

            if(operationType == 0) {
                union(nodes, operandA, operandB);
            } else if(operationType == 1) {
                sb.append((isSameSet(nodes, operandA, operandB)) ? VALID : INVALID).append("\n");
            } else {
                throw new IllegalArgumentException("Invalid Operation Type");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getParentNode(int[] nodes, int node) {
        if(nodes[node] == node) {
            return node;
        }
        return nodes[node] = getParentNode(nodes, nodes[node]);
    }

    private static void union(int[] nodes, int nodeA, int nodeB) {
        int parentOfNodeA = getParentNode(nodes, nodeA);
        int parentOfNodeB = getParentNode(nodes, nodeB);
        if(parentOfNodeA < parentOfNodeB) {
            nodes[parentOfNodeB] = parentOfNodeA;
        } else {
            nodes[parentOfNodeA] = parentOfNodeB;
        }
    }

    private static boolean isSameSet(int[] nodes, int nodeA, int nodeB) {
        return getParentNode(nodes, nodeA) == getParentNode(nodes, nodeB);
    }
}